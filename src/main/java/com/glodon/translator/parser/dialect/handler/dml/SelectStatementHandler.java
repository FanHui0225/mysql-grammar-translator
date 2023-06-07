package com.glodon.translator.parser.dialect.handler.dml;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLSelectStatement;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.segment.dml.predicate.LockSegment;
import com.glodon.translator.parser.segment.generic.ModelSegment;
import com.glodon.translator.parser.segment.generic.WindowSegment;
import com.glodon.translator.parser.segment.generic.WithSegment;
import com.glodon.translator.parser.statement.dml.SelectStatement;

import java.util.Optional;

public final class SelectStatementHandler implements SQLStatementHandler {

    private SelectStatementHandler() {
    }

    public static Optional<LimitSegment> getLimitSegment(final SelectStatement selectStatement) {
        if (selectStatement instanceof MySQLStatement) {
            return ((MySQLSelectStatement) selectStatement).getLimit();
        }
        return Optional.empty();
    }

    public static Optional<LockSegment> getLockSegment(final SelectStatement selectStatement) {
        if (selectStatement instanceof MySQLStatement) {
            return ((MySQLSelectStatement) selectStatement).getLock();
        }
        return Optional.empty();
    }

    public static Optional<WindowSegment> getWindowSegment(final SelectStatement selectStatement) {
        if (selectStatement instanceof MySQLStatement) {
            return ((MySQLSelectStatement) selectStatement).getWindow();
        }
        return Optional.empty();
    }

    public static Optional<WithSegment> getWithSegment(final SelectStatement selectStatement) {
        return Optional.empty();
    }

    public static Optional<ModelSegment> getModelSegment(final SelectStatement selectStatement) {
        return Optional.empty();
    }
}
