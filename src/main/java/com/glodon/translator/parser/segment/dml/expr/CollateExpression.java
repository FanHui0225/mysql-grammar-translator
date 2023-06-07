package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.simple.SimpleExpressionSegment;

public final class CollateExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SimpleExpressionSegment collateName;

    public CollateExpression(int startIndex, int stopIndex, SimpleExpressionSegment collateName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.collateName = collateName;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SimpleExpressionSegment getCollateName() {
        return collateName;
    }
}
