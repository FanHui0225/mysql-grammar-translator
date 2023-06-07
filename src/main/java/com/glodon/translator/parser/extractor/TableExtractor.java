package com.glodon.translator.parser.extractor;

import com.glodon.translator.parser.dialect.handler.ddl.CreateTableStatementHandler;
import com.glodon.translator.parser.dialect.handler.dml.InsertStatementHandler;
import com.glodon.translator.parser.dialect.handler.dml.SelectStatementHandler;
import com.glodon.translator.parser.segment.ddl.routine.RoutineBodySegment;
import com.glodon.translator.parser.segment.ddl.routine.ValidStatementSegment;
import com.glodon.translator.parser.segment.dml.assignment.AssignmentSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.combine.CombineSegment;
import com.glodon.translator.parser.segment.dml.expr.*;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubqueryExpressionSegment;
import com.glodon.translator.parser.segment.dml.item.*;
import com.glodon.translator.parser.segment.dml.order.item.ColumnOrderByItemSegment;
import com.glodon.translator.parser.segment.dml.order.item.OrderByItemSegment;
import com.glodon.translator.parser.segment.dml.predicate.LockSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;
import com.glodon.translator.parser.segment.generic.table.*;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.parser.statement.ddl.CreateViewStatement;
import com.glodon.translator.parser.statement.dml.DeleteStatement;
import com.glodon.translator.parser.statement.dml.InsertStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;
import com.glodon.translator.parser.statement.dml.UpdateStatement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public final class TableExtractor {

    private final Collection<SimpleTableSegment> rewriteTables = new LinkedList<>();

    private final Collection<TableSegment> tableContext = new LinkedList<>();

    private final Collection<JoinTableSegment> joinTables = new LinkedList<>();

    public void extractTablesFromSelect(final SelectStatement selectStatement) {
        if (selectStatement.getCombine().isPresent()) {
            CombineSegment combineSegment = selectStatement.getCombine().get();
            extractTablesFromSelect(combineSegment.getLeft());
            extractTablesFromSelect(combineSegment.getRight());
        }
        if (null != selectStatement.getFrom() && !selectStatement.getCombine().isPresent()) {
            extractTablesFromTableSegment(selectStatement.getFrom());
        }
        if (selectStatement.getWhere().isPresent()) {
            extractTablesFromExpression(selectStatement.getWhere().get().getExpr());
        }
        if (null != selectStatement.getProjections()) {
            extractTablesFromProjections(selectStatement.getProjections());
        }
        if (selectStatement.getGroupBy().isPresent()) {
            extractTablesFromOrderByItems(selectStatement.getGroupBy().get().getGroupByItems());
        }
        if (selectStatement.getOrderBy().isPresent()) {
            extractTablesFromOrderByItems(selectStatement.getOrderBy().get().getOrderByItems());
        }
        Optional<LockSegment> lockSegment = SelectStatementHandler.getLockSegment(selectStatement);
        lockSegment.ifPresent(this::extractTablesFromLock);
    }

    private void extractTablesFromTableSegment(final TableSegment tableSegment) {
        if (tableSegment instanceof SimpleTableSegment) {
            tableContext.add(tableSegment);
            rewriteTables.add((SimpleTableSegment) tableSegment);
        }
        if (tableSegment instanceof SubqueryTableSegment) {
            tableContext.add(tableSegment);
            TableExtractor tableExtractor = new TableExtractor();
            tableExtractor.extractTablesFromSelect(((SubqueryTableSegment) tableSegment).getSubquery().getSelect());
            rewriteTables.addAll(tableExtractor.rewriteTables);
            joinTables.addAll(tableExtractor.joinTables);
        }
        if (tableSegment instanceof JoinTableSegment) {
            joinTables.add((JoinTableSegment) tableSegment);
            extractTablesFromJoinTableSegment((JoinTableSegment) tableSegment);
        }
        if (tableSegment instanceof DeleteMultiTableSegment) {
            DeleteMultiTableSegment deleteMultiTableSegment = (DeleteMultiTableSegment) tableSegment;
            rewriteTables.addAll(deleteMultiTableSegment.getActualDeleteTables());
            extractTablesFromTableSegment(deleteMultiTableSegment.getRelationTable());
        }
    }

    private void extractTablesFromJoinTableSegment(final JoinTableSegment tableSegment) {
        extractTablesFromTableSegment(tableSegment.getLeft());
        extractTablesFromTableSegment(tableSegment.getRight());
        extractTablesFromExpression(tableSegment.getCondition());
    }

    private void extractTablesFromExpression(final ExpressionSegment expressionSegment) {
        if (expressionSegment instanceof ColumnSegment && ((ColumnSegment) expressionSegment).getOwner().isPresent() && needRewrite(((ColumnSegment) expressionSegment).getOwner().get())) {
            OwnerSegment ownerSegment = ((ColumnSegment) expressionSegment).getOwner().get();
            rewriteTables.add(new SimpleTableSegment(new TableNameSegment(ownerSegment.getStartIndex(), ownerSegment.getStopIndex(), ownerSegment.getIdentifier())));
        }
        if (expressionSegment instanceof ListExpression) {
            for (ExpressionSegment each : ((ListExpression) expressionSegment).getItems()) {
                extractTablesFromExpression(each);
            }
        }
        if (expressionSegment instanceof ExistsSubqueryExpression) {
            extractTablesFromSelect(((ExistsSubqueryExpression) expressionSegment).getSubquery().getSelect());
        }
        if (expressionSegment instanceof BetweenExpression) {
            extractTablesFromExpression(((BetweenExpression) expressionSegment).getLeft());
            extractTablesFromExpression(((BetweenExpression) expressionSegment).getBetweenExpr());
            extractTablesFromExpression(((BetweenExpression) expressionSegment).getAndExpr());
        }
        if (expressionSegment instanceof InExpression) {
            extractTablesFromExpression(((InExpression) expressionSegment).getLeft());
            extractTablesFromExpression(((InExpression) expressionSegment).getRight());
        }
        if (expressionSegment instanceof SubqueryExpressionSegment) {
            extractTablesFromSelect(((SubqueryExpressionSegment) expressionSegment).getSubquery().getSelect());
        }
        if (expressionSegment instanceof BinaryOperationExpression) {
            extractTablesFromExpression(((BinaryOperationExpression) expressionSegment).getLeft());
            extractTablesFromExpression(((BinaryOperationExpression) expressionSegment).getRight());
        }
    }

    private void extractTablesFromProjections(final ProjectionsSegment projections) {
        for (ProjectionSegment each : projections.getProjections()) {
            if (each instanceof SubqueryProjectionSegment) {
                extractTablesFromSelect(((SubqueryProjectionSegment) each).getSubquery().getSelect());
            } else if (each instanceof OwnerAvailable) {
                if (((OwnerAvailable) each).getOwner().isPresent() && needRewrite(((OwnerAvailable) each).getOwner().get())) {
                    OwnerSegment ownerSegment = ((OwnerAvailable) each).getOwner().get();
                    rewriteTables.add(createSimpleTableSegment(ownerSegment));
                }
            } else if (each instanceof ColumnProjectionSegment) {
                if (((ColumnProjectionSegment) each).getColumn().getOwner().isPresent() && needRewrite(((ColumnProjectionSegment) each).getColumn().getOwner().get())) {
                    OwnerSegment ownerSegment = ((ColumnProjectionSegment) each).getColumn().getOwner().get();
                    rewriteTables.add(createSimpleTableSegment(ownerSegment));
                }
            } else if (each instanceof AggregationProjectionSegment) {
                ((AggregationProjectionSegment) each).getParameters().forEach(this::extractTablesFromExpression);
            }
        }
    }

    private SimpleTableSegment createSimpleTableSegment(final OwnerSegment ownerSegment) {
        SimpleTableSegment result = new SimpleTableSegment(new TableNameSegment(ownerSegment.getStartIndex(), ownerSegment.getStopIndex(), ownerSegment.getIdentifier()));
        ownerSegment.getOwner().ifPresent(result::setOwner);
        return result;
    }

    private void extractTablesFromOrderByItems(final Collection<OrderByItemSegment> orderByItems) {
        for (OrderByItemSegment each : orderByItems) {
            if (each instanceof ColumnOrderByItemSegment) {
                Optional<OwnerSegment> owner = ((ColumnOrderByItemSegment) each).getColumn().getOwner();
                if (owner.isPresent() && needRewrite(owner.get())) {
                    rewriteTables.add(new SimpleTableSegment(new TableNameSegment(owner.get().getStartIndex(), owner.get().getStopIndex(), owner.get().getIdentifier())));
                }
            }
        }
    }

    private void extractTablesFromLock(final LockSegment lockSegment) {
        rewriteTables.addAll(lockSegment.getTables());
    }

    public void extractTablesFromDelete(final DeleteStatement deleteStatement) {
        extractTablesFromTableSegment(deleteStatement.getTable());
        if (deleteStatement.getWhere().isPresent()) {
            extractTablesFromExpression(deleteStatement.getWhere().get().getExpr());
        }
    }

    public void extractTablesFromInsert(final InsertStatement insertStatement) {
        if (null != insertStatement.getTable()) {
            extractTablesFromTableSegment(insertStatement.getTable());
        }
        if (!insertStatement.getColumns().isEmpty()) {
            for (ColumnSegment each : insertStatement.getColumns()) {
                extractTablesFromExpression(each);
            }
        }
        InsertStatementHandler.getOnDuplicateKeyColumnsSegment(insertStatement).ifPresent(optional -> extractTablesFromAssignmentItems(optional.getColumns()));
        if (insertStatement.getInsertSelect().isPresent()) {
            extractTablesFromSelect(insertStatement.getInsertSelect().get().getSelect());
        }
    }

    private void extractTablesFromAssignmentItems(final Collection<AssignmentSegment> assignmentItems) {
        assignmentItems.forEach(each -> extractTablesFromColumnSegments(each.getColumns()));
    }

    private void extractTablesFromColumnSegments(final Collection<ColumnSegment> columnSegments) {
        columnSegments.forEach(each -> {
            if (each.getOwner().isPresent() && needRewrite(each.getOwner().get())) {
                OwnerSegment ownerSegment = each.getOwner().get();
                rewriteTables.add(new SimpleTableSegment(new TableNameSegment(ownerSegment.getStartIndex(), ownerSegment.getStopIndex(), ownerSegment.getIdentifier())));
            }
        });
    }

    public void extractTablesFromUpdate(final UpdateStatement updateStatement) {
        extractTablesFromTableSegment(updateStatement.getTable());
        updateStatement.getSetAssignment().getAssignments().forEach(each -> extractTablesFromExpression(each.getColumns().get(0)));
        if (updateStatement.getWhere().isPresent()) {
            extractTablesFromExpression(updateStatement.getWhere().get().getExpr());
        }
    }

    public boolean needRewrite(final OwnerSegment owner) {
        for (TableSegment each : tableContext) {
            if (owner.getIdentifier().getValue().equalsIgnoreCase(each.getAliasName().orElse(null))) {
                return false;
            }
        }
        return true;
    }

    public Collection<SimpleTableSegment> extractExistTableFromRoutineBody(final RoutineBodySegment routineBody) {
        Collection<SimpleTableSegment> result = new LinkedList<>();
        for (ValidStatementSegment each : routineBody.getValidStatements()) {
            if (each.getAlterTable().isPresent()) {
                result.add(each.getAlterTable().get().getTable());
            }
            if (each.getDropTable().isPresent()) {
                result.addAll(each.getDropTable().get().getTables());
            }
            if (each.getTruncate().isPresent()) {
                result.addAll(each.getTruncate().get().getTables());
            }
            result.addAll(extractExistTableFromDMLStatement(each));
        }
        return result;
    }

    private Collection<SimpleTableSegment> extractExistTableFromDMLStatement(final ValidStatementSegment validStatementSegment) {
        if (validStatementSegment.getInsert().isPresent()) {
            extractTablesFromInsert(validStatementSegment.getInsert().get());
        } else if (validStatementSegment.getReplace().isPresent()) {
            extractTablesFromInsert(validStatementSegment.getReplace().get());
        } else if (validStatementSegment.getUpdate().isPresent()) {
            extractTablesFromUpdate(validStatementSegment.getUpdate().get());
        } else if (validStatementSegment.getDelete().isPresent()) {
            extractTablesFromDelete(validStatementSegment.getDelete().get());
        } else if (validStatementSegment.getSelect().isPresent()) {
            extractTablesFromSelect(validStatementSegment.getSelect().get());
        }
        return rewriteTables;
    }

    public Collection<SimpleTableSegment> extractNotExistTableFromRoutineBody(final RoutineBodySegment routineBody) {
        Collection<SimpleTableSegment> result = new LinkedList<>();
        for (ValidStatementSegment each : routineBody.getValidStatements()) {
            Optional<CreateTableStatement> createTable = each.getCreateTable();
            if (createTable.isPresent() && !CreateTableStatementHandler.ifNotExists(createTable.get())) {
                result.add(createTable.get().getTable());
            }
        }
        return result;
    }

    public void extractTablesFromSQLStatement(final SQLStatement sqlStatement) {
        if (sqlStatement instanceof SelectStatement) {
            extractTablesFromSelect((SelectStatement) sqlStatement);
        } else if (sqlStatement instanceof InsertStatement) {
            extractTablesFromInsert((InsertStatement) sqlStatement);
        } else if (sqlStatement instanceof UpdateStatement) {
            extractTablesFromUpdate((UpdateStatement) sqlStatement);
        } else if (sqlStatement instanceof DeleteStatement) {
            extractTablesFromDelete((DeleteStatement) sqlStatement);
        }
    }

    public void extractTablesFromCreateViewStatement(final CreateViewStatement createViewStatement) {
        tableContext.add(createViewStatement.getView());
        rewriteTables.add(createViewStatement.getView());
        extractTablesFromSelect(createViewStatement.getSelect());
    }

    public Collection<SimpleTableSegment> getRewriteTables() {
        return rewriteTables;
    }

    public Collection<TableSegment> getTableContext() {
        return tableContext;
    }

    public Collection<JoinTableSegment> getJoinTables() {
        return joinTables;
    }
}
