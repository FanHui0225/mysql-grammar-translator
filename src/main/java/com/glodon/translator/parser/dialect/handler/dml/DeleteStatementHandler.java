package com.glodon.translator.parser.dialect.handler.dml;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLDeleteStatement;
import com.glodon.translator.parser.segment.dml.order.OrderBySegment;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.segment.generic.OutputSegment;
import com.glodon.translator.parser.segment.generic.WithSegment;
import com.glodon.translator.parser.statement.dml.DeleteStatement;

import java.util.Optional;

public final class DeleteStatementHandler implements SQLStatementHandler {

    private DeleteStatementHandler() {
    }

    public static Optional<OrderBySegment> getOrderBySegment(final DeleteStatement deleteStatement) {
        if (deleteStatement instanceof MySQLStatement) {
            return ((MySQLDeleteStatement) deleteStatement).getOrderBy();
        }
        return Optional.empty();
    }

    public static Optional<LimitSegment> getLimitSegment(final DeleteStatement deleteStatement) {
        if (deleteStatement instanceof MySQLStatement) {
            return ((MySQLDeleteStatement) deleteStatement).getLimit();
        }
        return Optional.empty();
    }

    public static Optional<OutputSegment> getOutputSegment(final DeleteStatement deleteStatement) {
        return Optional.empty();
    }

    public static Optional<WithSegment> getWithSegment(final DeleteStatement deleteStatement) {
        return Optional.empty();
    }
}
