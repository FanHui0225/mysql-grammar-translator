package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class CloneActionSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private String cloneDir;

    private CloneInstanceSegment cloneInstance;

    public CloneActionSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getCloneDir() {
        return cloneDir;
    }

    public void setCloneDir(String cloneDir) {
        this.cloneDir = cloneDir;
    }

    public CloneInstanceSegment getCloneInstance() {
        return cloneInstance;
    }

    public void setCloneInstance(CloneInstanceSegment cloneInstance) {
        this.cloneInstance = cloneInstance;
    }
}
