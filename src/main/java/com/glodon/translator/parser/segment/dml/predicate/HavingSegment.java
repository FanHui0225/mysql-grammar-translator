package com.glodon.translator.parser.segment.dml.predicate;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

public final class HavingSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment expr;

    public HavingSegment(int startIndex, int stopIndex, ExpressionSegment expr) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.expr = expr;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ExpressionSegment getExpr() {
        return expr;
    }
}
