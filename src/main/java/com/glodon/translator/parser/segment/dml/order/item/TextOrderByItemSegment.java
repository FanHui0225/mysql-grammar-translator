package com.glodon.translator.parser.segment.dml.order.item;

import com.glodon.translator.parser.enums.NullsOrderType;
import com.glodon.translator.parser.enums.OrderDirection;

public abstract class TextOrderByItemSegment extends OrderByItemSegment {

    protected TextOrderByItemSegment(final int startIndex, final int stopIndex, final OrderDirection orderDirection, final NullsOrderType nullsOrderType) {
        super(startIndex, stopIndex, orderDirection, nullsOrderType);
    }

    public abstract String getText();
}
