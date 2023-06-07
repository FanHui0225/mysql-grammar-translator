package com.glodon.translator.parser.segment.dml.expr;

public final class NotExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment expression;

    public NotExpression(int startIndex, int stopIndex, ExpressionSegment expression) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.expression = expression;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ExpressionSegment getExpression() {
        return expression;
    }
}
