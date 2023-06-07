package com.glodon.translator.parser.segment.dml.expr;

public final class DatetimeExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment left;

    private final ExpressionSegment right;

    private final String text;

    public DatetimeExpression(final int startIndex, final int stopIndex, final ExpressionSegment left, final ExpressionSegment right, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = right;
        this.text = text;
    }

    public DatetimeExpression(final int startIndex, final int stopIndex, final ExpressionSegment left, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = null;
        this.text = text;
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

    public ExpressionSegment getRight() {
        return right;
    }

    public String getText() {
        return text;
    }
}
