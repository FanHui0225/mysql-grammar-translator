package com.glodon.translator.parser.segment.dml.pagination.rownum;

import com.glodon.translator.parser.segment.dml.pagination.NumberLiteralPaginationValueSegment;

public final class NumberLiteralRowNumberValueSegment extends RowNumberValueSegment implements NumberLiteralPaginationValueSegment {

    private final long value;

    public NumberLiteralRowNumberValueSegment(final int startIndex, final int stopIndex, final long value, final boolean boundOpened) {
        super(startIndex, stopIndex, boundOpened);
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }
}
