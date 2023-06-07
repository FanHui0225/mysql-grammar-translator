package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Optional;

public final class ColumnProjectionSegment implements ProjectionSegment, AliasAvailable {

    private final ColumnSegment column;

    public ColumnSegment getColumn() {
        return column;
    }

    private AliasSegment alias;

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public ColumnProjectionSegment(final ColumnSegment columnSegment) {
        column = columnSegment;
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
        return column.getStartIndex();
    }

    @Override
    public int getStopIndex() {
        return null == alias ? column.getStopIndex() : alias.getStopIndex();
    }
}
