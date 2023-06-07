package com.glodon.translator.parser.dialect.handler.dal;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dal.MySQLExplainStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dal.ExplainStatement;

import java.util.Optional;

public final class ExplainStatementHandler implements SQLStatementHandler {

    private ExplainStatementHandler() {
    }

    public static Optional<SimpleTableSegment> getSimpleTableSegment(final ExplainStatement explainStatement) {
        if (explainStatement instanceof MySQLStatement) {
            return ((MySQLExplainStatement) explainStatement).getTable();
        }
        return Optional.empty();
    }
}
