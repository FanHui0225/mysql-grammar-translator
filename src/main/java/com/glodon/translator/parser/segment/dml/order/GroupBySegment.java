
package com.glodon.translator.parser.segment.dml.order;


import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.order.item.OrderByItemSegment;

import java.util.Collection;

public final class GroupBySegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<OrderByItemSegment> groupByItems;

    public GroupBySegment(int startIndex, int stopIndex, Collection<OrderByItemSegment> groupByItems) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.groupByItems = groupByItems;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<OrderByItemSegment> getGroupByItems() {
        return groupByItems;
    }
}
