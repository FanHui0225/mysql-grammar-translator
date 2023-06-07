package com.glodon.translator.parser.segment.dml.assignment;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Collection;

public final class SetAssignmentSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<AssignmentSegment> assignments;

    public SetAssignmentSegment(int startIndex, int stopIndex, Collection<AssignmentSegment> assignments) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.assignments = assignments;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<AssignmentSegment> getAssignments() {
        return assignments;
    }
}
