package com.glodon.translator.parser.segment.dml.assignment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

import java.util.List;

public final class InsertValuesSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final List<ExpressionSegment> values;

    public InsertValuesSegment(int startIndex, int stopIndex, List<ExpressionSegment> values) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.values = values;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public List<ExpressionSegment> getValues() {
        return values;
    }
}
