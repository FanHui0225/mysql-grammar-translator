package com.glodon.translator.parser.segment.dml.pagination.top;

import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;
import com.glodon.translator.parser.segment.dml.pagination.rownum.RowNumberValueSegment;

public final class TopProjectionSegment implements ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final RowNumberValueSegment top;

    private final String alias;

    public TopProjectionSegment(int startIndex, int stopIndex, RowNumberValueSegment top, String alias) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.top = top;
        this.alias = alias;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public RowNumberValueSegment getTop() {
        return top;
    }

    public String getAlias() {
        return alias;
    }
}
