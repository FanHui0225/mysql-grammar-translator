package com.glodon.translator.parser.segment.dml.column;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.assignment.AssignmentSegment;

import java.util.Collection;

public final class OnDuplicateKeyColumnsSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<AssignmentSegment> columns;

    public OnDuplicateKeyColumnsSegment(int startIndex, int stopIndex, Collection<AssignmentSegment> columns) {
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

    public Collection<AssignmentSegment> getColumns() {
        return columns;
    }
}
