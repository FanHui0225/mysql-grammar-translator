package com.glodon.translator.parser.segment.dml.expr;

import java.util.Collection;

public final class CaseWhenExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ExpressionSegment caseExpr;

    private final Collection<ExpressionSegment> whenExprs;

    private final Collection<ExpressionSegment> thenExprs;

    private final ExpressionSegment elseExpr;

    public CaseWhenExpression(int startIndex, int stopIndex, ExpressionSegment caseExpr, Collection<ExpressionSegment> whenExprs, Collection<ExpressionSegment> thenExprs, ExpressionSegment elseExpr) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.caseExpr = caseExpr;
        this.whenExprs = whenExprs;
        this.thenExprs = thenExprs;
        this.elseExpr = elseExpr;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public ExpressionSegment getCaseExpr() {
        return caseExpr;
    }

    public Collection<ExpressionSegment> getWhenExprs() {
        return whenExprs;
    }

    public Collection<ExpressionSegment> getThenExprs() {
        return thenExprs;
    }

    public ExpressionSegment getElseExpr() {
        return elseExpr;
    }
}
