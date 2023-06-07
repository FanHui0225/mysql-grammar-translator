package com.glodon.translator.parser.segment.ddl.cursor;

import com.glodon.translator.parser.enums.DirectionType;
import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Optional;

public final class DirectionSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    public DirectionSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    private DirectionType directionType;

    private Long count;

    public Optional<DirectionType> getDirectionType() {
        return Optional.ofNullable(directionType);
    }

    public Optional<Long> getCount() {
        return Optional.ofNullable(count);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
