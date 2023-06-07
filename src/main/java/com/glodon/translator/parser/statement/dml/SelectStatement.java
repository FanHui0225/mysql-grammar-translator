package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.dml.combine.CombineSegment;
import com.glodon.translator.parser.segment.dml.item.ProjectionsSegment;
import com.glodon.translator.parser.segment.dml.order.GroupBySegment;
import com.glodon.translator.parser.segment.dml.order.OrderBySegment;
import com.glodon.translator.parser.segment.dml.predicate.HavingSegment;
import com.glodon.translator.parser.segment.dml.predicate.WhereSegment;
import com.glodon.translator.parser.segment.generic.table.TableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class SelectStatement extends AbstractSQLStatement implements DMLStatement {

    private ProjectionsSegment projections;

    private TableSegment from;

    private WhereSegment where;

    private GroupBySegment groupBy;

    private HavingSegment having;

    private OrderBySegment orderBy;

    private CombineSegment combine;

    public Optional<WhereSegment> getWhere() {
        return Optional.ofNullable(where);
    }

    public Optional<GroupBySegment> getGroupBy() {
        return Optional.ofNullable(groupBy);
    }

    public Optional<HavingSegment> getHaving() {
        return Optional.ofNullable(having);
    }

    public Optional<OrderBySegment> getOrderBy() {
        return Optional.ofNullable(orderBy);
    }

    public Optional<CombineSegment> getCombine() {
        return Optional.ofNullable(combine);
    }

    public ProjectionsSegment getProjections() {
        return projections;
    }

    public void setProjections(ProjectionsSegment projections) {
        this.projections = projections;
    }

    public TableSegment getFrom() {
        return from;
    }

    public void setFrom(TableSegment from) {
        this.from = from;
    }

    public void setWhere(WhereSegment where) {
        this.where = where;
    }

    public void setGroupBy(GroupBySegment groupBy) {
        this.groupBy = groupBy;
    }

    public void setHaving(HavingSegment having) {
        this.having = having;
    }

    public void setOrderBy(OrderBySegment orderBy) {
        this.orderBy = orderBy;
    }

    public void setCombine(CombineSegment combine) {
        this.combine = combine;
    }
}
