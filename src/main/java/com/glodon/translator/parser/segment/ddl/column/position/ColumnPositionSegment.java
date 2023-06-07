package com.glodon.translator.parser.segment.ddl.column.position;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

public abstract class ColumnPositionSegment implements SQLSegment, Comparable<ColumnPositionSegment> {

    private final int startIndex;

    private final int stopIndex;

    private final ColumnSegment columnName;

    public ColumnPositionSegment(int startIndex, int stopIndex, ColumnSegment columnName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnName = columnName;
    }

    @Override
    public final int compareTo(final ColumnPositionSegment o) {
        return startIndex - o.startIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ColumnSegment getColumnName() {
        return columnName;
    }
}
