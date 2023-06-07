package com.glodon.translator.parser.dialect.handler.dml;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLInsertStatement;
import com.glodon.translator.parser.segment.dml.ReturningSegment;
import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.column.OnDuplicateKeyColumnsSegment;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.generic.InsertMultiTableElementSegment;
import com.glodon.translator.parser.segment.generic.OutputSegment;
import com.glodon.translator.parser.segment.generic.WithSegment;
import com.glodon.translator.parser.statement.dml.InsertStatement;

import java.util.Optional;

public final class InsertStatementHandler implements SQLStatementHandler {

    private InsertStatementHandler() {
    }

    public static Optional<OnDuplicateKeyColumnsSegment> getOnDuplicateKeyColumnsSegment(final InsertStatement insertStatement) {
        if (insertStatement instanceof MySQLStatement) {
            return ((MySQLInsertStatement) insertStatement).getOnDuplicateKeyColumns();
        }
        return Optional.empty();
    }

    public static Optional<SetAssignmentSegment> getSetAssignmentSegment(final InsertStatement insertStatement) {
        return insertStatement instanceof MySQLStatement ? ((MySQLInsertStatement) insertStatement).getSetAssignment() : Optional.empty();
    }

    public static Optional<WithSegment> getWithSegment(final InsertStatement insertStatement) {
        return Optional.empty();
    }

    public static Optional<OutputSegment> getOutputSegment(final InsertStatement insertStatement) {
        return Optional.empty();
    }

    public static Optional<InsertMultiTableElementSegment> getInsertMultiTableElementSegment(final InsertStatement insertStatement) {
        return Optional.empty();
    }

    public static Optional<SubquerySegment> getSelectSubquery(final InsertStatement insertStatement) {
        return Optional.empty();
    }

    public static Optional<ReturningSegment> getReturningSegment(final InsertStatement insertStatement) {
        return Optional.empty();
    }
}
