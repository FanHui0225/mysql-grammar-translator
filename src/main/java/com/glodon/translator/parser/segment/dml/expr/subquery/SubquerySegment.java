package com.glodon.translator.parser.segment.dml.expr.subquery;

import com.glodon.translator.parser.enums.SubqueryType;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public final class SubquerySegment implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SelectStatement select;

    private SubqueryType subqueryType;

    public void setSubqueryType(SubqueryType subqueryType) {
        this.subqueryType = subqueryType;
    }

    public SubquerySegment(int startIndex, int stopIndex, SelectStatement select) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.select = select;
    }

    public SubquerySegment(int startIndex, int stopIndex, SelectStatement select, SubqueryType subqueryType) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.select = select;
        this.subqueryType = subqueryType;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SelectStatement getSelect() {
        return select;
    }

    public SubqueryType getSubqueryType() {
        return subqueryType;
    }
}
