
package com.glodon.translator.parser.segment.dml.expr.simple;

public class LiteralExpressionSegment implements SimpleExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Object literals;

    public LiteralExpressionSegment(int startIndex, int stopIndex, Object literals) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.literals = literals;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public Object getLiterals() {
        return literals;
    }
}
