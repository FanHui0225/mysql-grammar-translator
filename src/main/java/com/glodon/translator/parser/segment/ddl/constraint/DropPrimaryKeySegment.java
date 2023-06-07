package com.glodon.translator.parser.segment.ddl.constraint;

import com.glodon.translator.parser.segment.SQLSegment;

public final class DropPrimaryKeySegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    public DropPrimaryKeySegment(int startIndex, int stopIndex) {
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
