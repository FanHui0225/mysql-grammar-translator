package com.glodon.translator.parser.segment.dml.expr.complex;

public final class CommonExpressionSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String text;

    public CommonExpressionSegment(int startIndex, int stopIndex, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.text = text;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public String getText() {
        return text;
    }
}
