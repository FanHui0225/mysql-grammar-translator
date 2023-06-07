package com.glodon.translator.parser.segment.dml.column;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Collection;

public final class InsertColumnsSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ColumnSegment> columns;

    public InsertColumnsSegment(int startIndex, int stopIndex, Collection<ColumnSegment> columns) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columns = columns;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ColumnSegment> getColumns() {
        return columns;
    }
}
