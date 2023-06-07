package com.glodon.translator.parser.segment.dml.order.item;

import com.glodon.translator.parser.enums.NullsOrderType;
import com.glodon.translator.parser.enums.OrderDirection;
import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Optional;

public abstract class OrderByItemSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final OrderDirection orderDirection;

    private final NullsOrderType nullsOrderType;

    public OrderByItemSegment(int startIndex, int stopIndex, OrderDirection orderDirection, NullsOrderType nullsOrderType) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.orderDirection = orderDirection;
        this.nullsOrderType = nullsOrderType;
    }

    public Optional<NullsOrderType> getNullsOrderType() {
        return Optional.ofNullable(nullsOrderType);
    }

    public NullsOrderType getNullsOrderType(final String databaseType) {
        if (null != nullsOrderType) {
            return nullsOrderType;
        }
        if ("PostgreSQL".equals(databaseType) || "openGauss".equals(databaseType) || "Oracle".equals(databaseType)) {
            return OrderDirection.ASC == orderDirection ? NullsOrderType.LAST : NullsOrderType.FIRST;
        }
        return OrderDirection.ASC == orderDirection ? NullsOrderType.FIRST : NullsOrderType.LAST;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }
}
