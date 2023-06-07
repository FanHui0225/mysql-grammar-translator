package com.glodon.translator.parser.segment.tcl;

import com.glodon.translator.parser.segment.SQLSegment;

public final class AutoCommitSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final boolean autoCommit;

    public AutoCommitSegment(int startIndex, int stopIndex, boolean autoCommit) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.autoCommit = autoCommit;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }
}
