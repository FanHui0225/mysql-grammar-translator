package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class CopyStatement extends AbstractSQLStatement implements DMLStatement {
    
    private SimpleTableSegment tableSegment;

    public SimpleTableSegment getTableSegment() {
        return tableSegment;
    }

    public void setTableSegment(SimpleTableSegment tableSegment) {
        this.tableSegment = tableSegment;
    }
}
