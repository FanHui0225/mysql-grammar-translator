package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLInsertStatement;
import com.glodon.translator.parser.segment.dml.assignment.AssignmentSegment;
import com.glodon.translator.parser.segment.dml.assignment.InsertValuesSegment;
import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.column.InsertColumnsSegment;
import com.glodon.translator.parser.segment.dml.column.OnDuplicateKeyColumnsSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.CommonExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.simple.LiteralExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

public class InsertStatementTranslator extends SQLStatementTranslator<MySQLInsertStatement> {

    public InsertStatementTranslator() {
        append("INSERT").appendBlankSpace().append("INTO").appendBlankSpace();
    }

    @Override
    public String translate(MySQLInsertStatement statement) {
        SimpleTableSegment tableSegment = statement.getTable();
        IdentifierValue tableName;
        if (null == tableSegment || null == (tableName = tableSegment.getTableName())) {
            throw new SQLTranslatorException("insert into table name segment required.");
        }
        if (tableSegment.getOwner().isPresent()) {
            append(tableSegment.getOwner().get().getIdentifier().getValue().toUpperCase()).append('.');
        }
        append(tableName.getValue().toUpperCase()).appendBlankSpace();
        Optional<SetAssignmentSegment> setAssignmentSegmentOptional = statement.getSetAssignment();
        Optional<SubquerySegment> subquerySegmentOptional = statement.getInsertSelect();
        if (setAssignmentSegmentOptional.isPresent()) {
            append(new SetAssignmentSegmentTranslator().translate(setAssignmentSegmentOptional.get()));
        } else if (subquerySegmentOptional.isPresent()) {
            SubquerySegment subquerySegment = subquerySegmentOptional.get();
            //TODO translate subquerySegment
        } else {
            Collection<InsertValuesSegment> valuesSegments = statement.getValues();
            Optional<InsertColumnsSegment> insertColumnsSegmentOptional = statement.getInsertColumns();
            if (insertColumnsSegmentOptional.isPresent()) {
                append(new InsertColumnsSegmentTranslator().translate(insertColumnsSegmentOptional.get())).appendBlankSpace();
            }
            append("VALUES").appendLineFeed();
            Iterator<InsertValuesSegment> it = valuesSegments.iterator();
            while (it.hasNext()) {
                InsertValuesSegment insertValuesSegment = it.next();
                append(new InsertValuesSegmentTranslator().translate(insertValuesSegment));
                if (it.hasNext()) {
                    append(',').appendLineFeed();
                }
            }
        }
        Optional<OnDuplicateKeyColumnsSegment> onDuplicateKeyColumnsSegment = statement.getOnDuplicateKeyColumns();
        //TODO translate onDuplicateKeyColumnsSegment
        append(';');
        return toString();
    }
}
