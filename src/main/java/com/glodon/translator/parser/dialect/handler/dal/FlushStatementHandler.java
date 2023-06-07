package com.glodon.translator.parser.dialect.handler.dal;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dal.MySQLFlushStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dal.FlushStatement;

import java.util.Collection;
import java.util.Collections;

public final class FlushStatementHandler implements SQLStatementHandler {

    private FlushStatementHandler() {
    }

    public static Collection<SimpleTableSegment> getSimpleTableSegment(final FlushStatement flushStatement) {
        if (flushStatement instanceof MySQLStatement) {
            return ((MySQLFlushStatement) flushStatement).getTables();
        }
        return Collections.emptyList();
    }
}
