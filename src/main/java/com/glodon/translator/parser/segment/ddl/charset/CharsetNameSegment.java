package com.glodon.translator.parser.segment.ddl.charset;

import com.glodon.translator.parser.segment.SQLSegment;

public final class CharsetNameSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String name;

    public CharsetNameSegment(int startIndex, int stopIndex, String name) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.name = name;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getName() {
        return name;
    }
}
