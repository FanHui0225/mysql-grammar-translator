package com.glodon.translator.parser.segment.ddl.index;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public final class IndexTypeSegment implements SQLSegment, OwnerAvailable {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue identifier;

    private OwnerSegment owner;

    public IndexTypeSegment(int startIndex, int stopIndex, IdentifierValue identifier) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
    }

    @Override
    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
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

    @Override
    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }
}
