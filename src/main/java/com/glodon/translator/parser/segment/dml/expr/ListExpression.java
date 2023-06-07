package com.glodon.translator.parser.segment.dml.expr;

import java.util.LinkedList;
import java.util.List;

public final class ListExpression implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final List<ExpressionSegment> items = new LinkedList<>();

    public ListExpression(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public List<ExpressionSegment> getItems() {
        return items;
    }
}
