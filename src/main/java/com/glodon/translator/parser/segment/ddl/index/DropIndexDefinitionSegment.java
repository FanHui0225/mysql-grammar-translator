
package com.glodon.translator.parser.segment.ddl.index;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;

public final class DropIndexDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IndexSegment indexSegment;

    public DropIndexDefinitionSegment(int startIndex, int stopIndex, IndexSegment indexSegment) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.indexSegment = indexSegment;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public IndexSegment getIndexSegment() {
        return indexSegment;
    }
}
