package com.glodon.translator.parser.segment.dml.pagination.rownum;

import com.glodon.translator.parser.segment.dml.pagination.PaginationValueSegment;

public abstract class RowNumberValueSegment implements PaginationValueSegment {

    private final int startIndex;

    private final int stopIndex;

    private final boolean boundOpened;

    public RowNumberValueSegment(int startIndex, int stopIndex, boolean boundOpened) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.boundOpened = boundOpened;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public boolean isBoundOpened() {
        return boundOpened;
    }
}
