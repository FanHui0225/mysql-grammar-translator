package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

public final class GrantLevelSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String dbName;

    private final String tableName;

    public GrantLevelSegment(int startIndex, int stopIndex, String dbName, String tableName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.dbName = dbName;
        this.tableName = tableName;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getDbName() {
        return dbName;
    }

    public String getTableName() {
        return tableName;
    }
}
