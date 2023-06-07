package com.glodon.translator.parser.segment.dml.pagination.limit;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.pagination.PaginationValueSegment;

import java.util.Optional;

public final class LimitSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final PaginationValueSegment offset;

    private final PaginationValueSegment rowCount;

    public LimitSegment(int startIndex, int stopIndex, PaginationValueSegment offset, PaginationValueSegment rowCount) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.offset = offset;
        this.rowCount = rowCount;
    }

    public Optional<PaginationValueSegment> getOffset() {
        return Optional.ofNullable(offset);
    }

    public Optional<PaginationValueSegment> getRowCount() {
        return Optional.ofNullable(rowCount);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }
}
