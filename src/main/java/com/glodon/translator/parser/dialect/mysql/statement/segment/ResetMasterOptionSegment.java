package com.glodon.translator.parser.dialect.mysql.statement.segment;

public final class ResetMasterOptionSegment extends ResetOptionSegment {

    private int startIndex;

    private int stopIndex;

    private Long binaryLogFileIndexNumber;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public Long getBinaryLogFileIndexNumber() {
        return binaryLogFileIndexNumber;
    }

    public void setBinaryLogFileIndexNumber(Long binaryLogFileIndexNumber) {
        this.binaryLogFileIndexNumber = binaryLogFileIndexNumber;
    }
}
