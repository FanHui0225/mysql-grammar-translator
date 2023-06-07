package com.glodon.translator.parser.segment.dml.expr.subquery;

import com.glodon.translator.parser.segment.dml.expr.simple.SimpleExpressionSegment;

public final class SubqueryExpressionSegment implements SimpleExpressionSegment {

    private final SubquerySegment subquery;

    public SubquerySegment getSubquery() {
        return subquery;
    }

    public SubqueryExpressionSegment(SubquerySegment subquery) {
        this.subquery = subquery;
    }

    @Override
    public int getStartIndex() {
        return subquery.getStartIndex();
    }

    @Override
    public int getStopIndex() {
        return subquery.getStopIndex();
    }
}
