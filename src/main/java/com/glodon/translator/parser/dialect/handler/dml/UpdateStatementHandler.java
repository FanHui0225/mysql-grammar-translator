package com.glodon.translator.parser.dialect.handler.dml;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLUpdateStatement;
import com.glodon.translator.parser.segment.dml.order.OrderBySegment;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.statement.dml.UpdateStatement;

import java.util.Optional;

public final class UpdateStatementHandler implements SQLStatementHandler {

    private UpdateStatementHandler() {
    }

    public static Optional<OrderBySegment> getOrderBySegment(final UpdateStatement updateStatement) {
        if (updateStatement instanceof MySQLStatement) {
            return ((MySQLUpdateStatement) updateStatement).getOrderBy();
        }
        return Optional.empty();
    }

    public static Optional<LimitSegment> getLimitSegment(final UpdateStatement updateStatement) {
        if (updateStatement instanceof MySQLStatement) {
            return ((MySQLUpdateStatement) updateStatement).getLimit();
        }
        return Optional.empty();
    }
}
