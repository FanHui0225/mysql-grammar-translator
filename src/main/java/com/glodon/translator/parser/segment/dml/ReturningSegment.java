package com.glodon.translator.parser.segment.dml;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.item.ProjectionsSegment;

public final class ReturningSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ProjectionsSegment projections;

    public ReturningSegment(int startIndex, int stopIndex, ProjectionsSegment projections) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.projections = projections;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ProjectionsSegment getProjections() {
        return projections;
    }
}
