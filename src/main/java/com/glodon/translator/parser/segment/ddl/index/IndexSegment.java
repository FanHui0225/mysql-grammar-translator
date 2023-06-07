package com.glodon.translator.parser.segment.ddl.index;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;

import java.util.Optional;

public final class IndexSegment implements SQLSegment, OwnerAvailable {

    private final int startIndex;

    private final int stopIndex;

    private final IndexNameSegment indexName;

    private OwnerSegment owner;

    public IndexSegment(int startIndex, int stopIndex, IndexNameSegment indexName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.indexName = indexName;
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

    public IndexNameSegment getIndexName() {
        return indexName;
    }

    @Override
    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }
}
