package com.glodon.translator.parser.segment.ddl.index;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;

public final class RenameIndexDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IndexSegment indexSegment;

    private final IndexSegment renameIndexSegment;

    public RenameIndexDefinitionSegment(int startIndex, int stopIndex, IndexSegment indexSegment, IndexSegment renameIndexSegment) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.indexSegment = indexSegment;
        this.renameIndexSegment = renameIndexSegment;
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

    public IndexSegment getRenameIndexSegment() {
        return renameIndexSegment;
    }
}
