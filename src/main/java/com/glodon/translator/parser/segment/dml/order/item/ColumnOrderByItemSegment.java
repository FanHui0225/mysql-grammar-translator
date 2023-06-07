package com.glodon.translator.parser.segment.dml.order.item;

import com.glodon.translator.parser.enums.NullsOrderType;
import com.glodon.translator.parser.enums.OrderDirection;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

public final class ColumnOrderByItemSegment extends TextOrderByItemSegment {

    private final ColumnSegment column;

    public ColumnOrderByItemSegment(final ColumnSegment column, final OrderDirection orderDirection, final NullsOrderType nullsOrderType) {
        super(column.getStartIndex(), column.getStopIndex(), orderDirection, nullsOrderType);
        this.column = column;
    }

    @Override
    public String getText() {
        return column.getQualifiedName();
    }

    public ColumnSegment getColumn() {
        return column;
    }
}
