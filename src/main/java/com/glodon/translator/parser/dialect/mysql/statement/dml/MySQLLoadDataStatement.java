package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dml.DMLStatement;

public final class MySQLLoadDataStatement extends AbstractSQLStatement implements DMLStatement, MySQLStatement {

    private final SimpleTableSegment tableSegment;

    public MySQLLoadDataStatement(SimpleTableSegment tableSegment) {
        this.tableSegment = tableSegment;
    }

    public SimpleTableSegment getTableSegment() {
        return tableSegment;
    }
}
