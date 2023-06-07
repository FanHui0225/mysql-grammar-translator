package com.glodon.translator.parser.segment.dml.assignment;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

import java.util.List;

public final class ColumnAssignmentSegment implements AssignmentSegment {

    private final int startIndex;

    private final int stopIndex;

    private final List<ColumnSegment> columns;

    private final ExpressionSegment value;

    public ColumnAssignmentSegment(int startIndex, int stopIndex, List<ColumnSegment> columns, ExpressionSegment value) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columns = columns;
        this.value = value;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public List<ColumnSegment> getColumns() {
        return columns;
    }

    @Override
    public ExpressionSegment getValue() {
        return value;
    }
}
