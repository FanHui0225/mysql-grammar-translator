package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

public final class PartitionSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue name;

    public PartitionSegment(int startIndex, int stopIndex, IdentifierValue name) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.name = name;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public IdentifierValue getName() {
        return name;
    }
}
