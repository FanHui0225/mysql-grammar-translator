package com.glodon.translator.parser.segment.dml.expr;

public final class BetweenExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment left;

    private final ExpressionSegment betweenExpr;

    private final ExpressionSegment andExpr;

    private final boolean not;

    public BetweenExpression(int startIndex, int stopIndex, ExpressionSegment left, ExpressionSegment betweenExpr, ExpressionSegment andExpr, boolean not) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.betweenExpr = betweenExpr;
        this.andExpr = andExpr;
        this.not = not;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ExpressionSegment getLeft() {
        return left;
    }

    public ExpressionSegment getBetweenExpr() {
        return betweenExpr;
    }

    public ExpressionSegment getAndExpr() {
        return andExpr;
    }

    public boolean isNot() {
        return not;
    }
}
