package com.glodon.translator.parser.segment.dml.pagination.limit;

import com.glodon.translator.parser.segment.dml.pagination.ParameterMarkerPaginationValueSegment;

public final class ParameterMarkerLimitValueSegment extends LimitValueSegment implements ParameterMarkerPaginationValueSegment {

    private final int parameterIndex;

    public ParameterMarkerLimitValueSegment(final int startIndex, final int stopIndex, final int paramIndex) {
        super(startIndex, stopIndex);
        this.parameterIndex = paramIndex;
    }

    public int getParameterIndex() {
        return parameterIndex;
    }
}
