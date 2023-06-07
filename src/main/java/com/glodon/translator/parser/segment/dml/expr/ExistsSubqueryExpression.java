package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;

public class ExistsSubqueryExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SubquerySegment subquery;

    private boolean not;

    public void setNot(boolean not) {
        this.not = not;
    }

    public ExistsSubqueryExpression(int startIndex, int stopIndex, SubquerySegment subquery) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.subquery = subquery;
    }

    public ExistsSubqueryExpression(int startIndex, int stopIndex, SubquerySegment subquery, boolean not) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.subquery = subquery;
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

    public SubquerySegment getSubquery() {
        return subquery;
    }

    public boolean isNot() {
        return not;
    }
}
