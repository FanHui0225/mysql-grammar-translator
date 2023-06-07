package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.dml.order.OrderBySegment;

import java.util.LinkedList;
import java.util.List;

public final class ModelSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final List<SubquerySegment> referenceModelSelects = new LinkedList<>();

    private final List<OrderBySegment> orderBySegments = new LinkedList<>();

    private final List<ColumnSegment> cellAssignmentColumns = new LinkedList<>();

    private final List<SubquerySegment> cellAssignmentSelects = new LinkedList<>();

    public ModelSegment(int startIndex, int stopIndex) {
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

    public List<SubquerySegment> getReferenceModelSelects() {
        return referenceModelSelects;
    }

    public List<OrderBySegment> getOrderBySegments() {
        return orderBySegments;
    }

    public List<ColumnSegment> getCellAssignmentColumns() {
        return cellAssignmentColumns;
    }

    public List<SubquerySegment> getCellAssignmentSelects() {
        return cellAssignmentSelects;
    }
}
