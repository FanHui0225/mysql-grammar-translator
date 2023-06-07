package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class ProjectionsSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ProjectionSegment> projections = new LinkedList<>();

    private boolean distinctRow;

    public ProjectionsSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public void setDistinctRow(boolean distinctRow) {
        this.distinctRow = distinctRow;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ProjectionSegment> getProjections() {
        return projections;
    }

    public boolean isDistinctRow() {
        return distinctRow;
    }
}
