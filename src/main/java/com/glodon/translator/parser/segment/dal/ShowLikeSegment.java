package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.SQLSegment;

public final class ShowLikeSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String pattern;

    public ShowLikeSegment(int startIndex, int stopIndex, String pattern) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.pattern = pattern;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getPattern() {
        return pattern;
    }
}
