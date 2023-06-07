package com.glodon.translator.parser.segment.tcl;

import com.glodon.translator.parser.segment.SQLSegment;

public final class ImplicitTransactionsSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final boolean on;

    public ImplicitTransactionsSegment(int startIndex, int stopIndex, boolean on) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.on = on;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public boolean isOn() {
        return on;
    }
}
