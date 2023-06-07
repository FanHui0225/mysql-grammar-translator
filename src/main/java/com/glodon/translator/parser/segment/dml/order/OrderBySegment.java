
package com.glodon.translator.parser.segment.dml.order;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.order.item.OrderByItemSegment;

import java.util.Collection;

public final class OrderBySegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<OrderByItemSegment> orderByItems;

    public OrderBySegment(int startIndex, int stopIndex, Collection<OrderByItemSegment> orderByItems) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.orderByItems = orderByItems;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<OrderByItemSegment> getOrderByItems() {
        return orderByItems;
    }
}
