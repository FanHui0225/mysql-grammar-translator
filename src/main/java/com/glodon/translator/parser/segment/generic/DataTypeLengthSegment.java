package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Optional;

public final class DataTypeLengthSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private int precision;

    private int scale;

    public Optional<Integer> getScale() {
        return Optional.of(scale);
    }

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

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
