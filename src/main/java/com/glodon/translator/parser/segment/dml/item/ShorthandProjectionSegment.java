package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;

import java.util.Optional;

public final class ShorthandProjectionSegment implements ProjectionSegment, OwnerAvailable, AliasAvailable {

    private final int startIndex;

    private final int stopIndex;

    private OwnerSegment owner;

    private AliasSegment alias;

    public ShorthandProjectionSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
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
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }
}
