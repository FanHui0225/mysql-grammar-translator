package com.glodon.translator.parser.segment.dml.expr;

public final class BinaryOperationExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment left;

    private final ExpressionSegment right;

    private final String operator;

    private final String text;

    public BinaryOperationExpression(int startIndex, int stopIndex, ExpressionSegment left, ExpressionSegment right, String operator, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = right;
        this.operator = operator;
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

    public String getOperator() {
        return operator;
    }

    public String getText() {
        return text;
    }
}
