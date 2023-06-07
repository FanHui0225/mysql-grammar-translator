package com.glodon.translator.parser.segment.generic.table;

import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Optional;

public final class SubqueryTableSegment implements TableSegment {

    private final SubquerySegment subquery;

    private AliasSegment alias;

    public SubqueryTableSegment(SubquerySegment subquery) {
        this.subquery = subquery;
    }

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

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
        return subquery.getStartIndex();
    }

    @Override
    public int getStopIndex() {
        return subquery.getStopIndex();
    }

    public SubquerySegment getSubquery() {
        return subquery;
    }
}
