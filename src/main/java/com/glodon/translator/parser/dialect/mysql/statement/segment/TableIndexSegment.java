package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

public abstract class TableIndexSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SimpleTableSegment table;

    public TableIndexSegment(int startIndex, int stopIndex, SimpleTableSegment table) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.table = table;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SimpleTableSegment getTable() {
        return table;
    }
}
