package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public final class OwnerSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue identifier;

    private OwnerSegment owner;

    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
    }

    public OwnerSegment(int startIndex, int stopIndex, IdentifierValue identifier) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
    }

    public OwnerSegment(int startIndex, int stopIndex, IdentifierValue identifier, OwnerSegment owner) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
        this.owner = owner;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public IdentifierValue getIdentifier() {
        return identifier;
    }

    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }
}
