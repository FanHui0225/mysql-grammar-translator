package com.glodon.translator.parser.segment.dml.pagination.limit;

import com.glodon.translator.parser.segment.dml.pagination.PaginationValueSegment;

public abstract class LimitValueSegment implements PaginationValueSegment {

    private final int startIndex;

    private final int stopIndex;

    public LimitValueSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public final boolean isBoundOpened() {
        return false;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }
}
