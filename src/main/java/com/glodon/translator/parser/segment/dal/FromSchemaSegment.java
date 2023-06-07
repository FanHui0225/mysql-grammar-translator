package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.DatabaseSegment;

public final class FromSchemaSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final DatabaseSegment schema;

    public FromSchemaSegment(int startIndex, int stopIndex, DatabaseSegment schema) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.schema = schema;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public DatabaseSegment getSchema() {
        return schema;
    }
}
