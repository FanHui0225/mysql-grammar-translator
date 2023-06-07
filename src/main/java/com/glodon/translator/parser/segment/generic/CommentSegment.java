package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

public final class CommentSegment implements SQLSegment {

    private final String text;

    private final int startIndex;

    private final int stopIndex;

    public CommentSegment(String text, int startIndex, int stopIndex) {
        this.text = text;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public String getText() {
        return text;
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
