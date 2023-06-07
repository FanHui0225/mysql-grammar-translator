package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.order.OrderBySegment;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.statement.dml.UpdateStatement;

import java.util.Optional;

public final class MySQLUpdateStatement extends UpdateStatement implements MySQLStatement {

    private OrderBySegment orderBy;

    private LimitSegment limit;

    public Optional<OrderBySegment> getOrderBy() {
        return Optional.ofNullable(orderBy);
    }

    public Optional<LimitSegment> getLimit() {
        return Optional.ofNullable(limit);
    }

    public void setOrderBy(OrderBySegment orderBy) {
        this.orderBy = orderBy;
    }

    public void setLimit(LimitSegment limit) {
        this.limit = limit;
    }
}
