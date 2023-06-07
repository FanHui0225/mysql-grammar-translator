package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Optional;

public final class SubqueryProjectionSegment implements ProjectionSegment, AliasAvailable {

    private final SubquerySegment subquery;

    private final String text;

    public SubqueryProjectionSegment(SubquerySegment subquery, String text) {
        this.subquery = subquery;
        this.text = text;
    }

    private AliasSegment alias;

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

    public String getText() {
        return text;
    }
}
