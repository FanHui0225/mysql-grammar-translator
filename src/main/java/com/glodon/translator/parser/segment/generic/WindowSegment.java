package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

public final class WindowSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    public WindowSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
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
