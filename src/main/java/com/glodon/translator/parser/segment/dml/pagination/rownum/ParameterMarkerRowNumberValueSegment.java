package com.glodon.translator.parser.segment.dml.pagination.rownum;

import com.glodon.translator.parser.segment.dml.pagination.ParameterMarkerPaginationValueSegment;

public final class ParameterMarkerRowNumberValueSegment extends RowNumberValueSegment implements ParameterMarkerPaginationValueSegment {

    private final int parameterIndex;

    public ParameterMarkerRowNumberValueSegment(final int startIndex, final int stopIndex, final int paramIndex, final boolean boundOpened) {
        super(startIndex, stopIndex, boundOpened);
        this.parameterIndex = paramIndex;
    }

    public int getParameterIndex() {
        return parameterIndex;
    }
}
