package com.glodon.translator.parser.segment.generic.table;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class JoinTableSegment implements TableSegment {

    private int startIndex;

    private int stopIndex;

    private AliasSegment alias;

    private TableSegment left;

    private boolean natural;

    private String joinType;

    private TableSegment right;

    private ExpressionSegment condition;

    private List<ColumnSegment> using = Collections.emptyList();

    @Override
    public Optional<String> getAliasName() {
        return null == alias ? Optional.empty() : Optional.ofNullable(alias.getIdentifier().getValue());
    }

    @Override
    public Optional<AliasSegment> getAlias() {
        return Optional.ofNullable(alias);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public TableSegment getLeft() {
        return left;
    }

    public void setLeft(TableSegment left) {
        this.left = left;
    }

    public boolean isNatural() {
        return natural;
    }

    public void setNatural(boolean natural) {
        this.natural = natural;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public TableSegment getRight() {
        return right;
    }

    public void setRight(TableSegment right) {
        this.right = right;
    }

    public ExpressionSegment getCondition() {
        return condition;
    }

    public void setCondition(ExpressionSegment condition) {
        this.condition = condition;
    }

    public List<ColumnSegment> getUsing() {
        return using;
    }

    public void setUsing(List<ColumnSegment> using) {
        this.using = using;
    }
}
