package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

public final class DatetimeProjectionSegment implements ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment left;

    private final ExpressionSegment right;

    private final String text;

    public DatetimeProjectionSegment(final int startIndex, final int stopIndex, final ExpressionSegment left, final ExpressionSegment right, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = right;
        this.text = text;
    }

    public DatetimeProjectionSegment(final int startIndex, final int stopIndex, final ExpressionSegment left, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = null;
        this.text = text;
    }

    public int getStartIndex() {
        return startIndex;
    }

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
