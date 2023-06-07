package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dal.FlushStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLFlushStatement extends FlushStatement implements MySQLStatement {

    private final Collection<SimpleTableSegment> tables = new LinkedList<>();

    private boolean flushTable;

    public Collection<SimpleTableSegment> getTables() {
        return tables;
    }

    public boolean isFlushTable() {
        return flushTable;
    }

    public void setFlushTable(boolean flushTable) {
        this.flushTable = flushTable;
    }
}
