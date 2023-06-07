package com.glodon.translator.parser.segment.dml.expr;

import java.util.Collection;
import java.util.LinkedList;

public final class InExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment left;

    private final ExpressionSegment right;

    private final boolean not;

    public InExpression(int startIndex, int stopIndex, ExpressionSegment left, ExpressionSegment right, boolean not) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.right = right;
        this.not = not;
    }

    public Collection<ExpressionSegment> getExpressionList() {
        Collection<ExpressionSegment> result = new LinkedList<>();
        if (right instanceof ListExpression) {
            result.addAll(((ListExpression) right).getItems());
        } else {
            result.add(this);
        }
        return result;
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

    public boolean isNot() {
        return not;
    }
}
