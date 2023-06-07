package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

public final class DataTypeSegment implements ExpressionSegment {

    private int startIndex;

    private int stopIndex;

    private String dataTypeName;

    private DataTypeLengthSegment dataLength;

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public DataTypeLengthSegment getDataLength() {
        return dataLength;
    }

    public void setDataLength(DataTypeLengthSegment dataLength) {
        this.dataLength = dataLength;
    }
}
