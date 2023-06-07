package com.glodon.translator.parser.segment.dml.pagination.limit;

import com.glodon.translator.parser.segment.dml.pagination.NumberLiteralPaginationValueSegment;

public final class NumberLiteralLimitValueSegment extends LimitValueSegment implements NumberLiteralPaginationValueSegment {

    private final long value;

    public NumberLiteralLimitValueSegment(final int startIndex, final int stopIndex, final long value) {
        super(startIndex, stopIndex);
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }
}
