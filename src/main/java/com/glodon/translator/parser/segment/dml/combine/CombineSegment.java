package com.glodon.translator.parser.segment.dml.combine;

import com.glodon.translator.parser.enums.CombineType;
import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public final class CombineSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SelectStatement left;

    private final CombineType combineType;

    private final SelectStatement right;

    public CombineSegment(int startIndex, int stopIndex, SelectStatement left, CombineType combineType, SelectStatement right) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.left = left;
        this.combineType = combineType;
        this.right = right;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SelectStatement getLeft() {
        return left;
    }

    public CombineType getCombineType() {
        return combineType;
    }

    public SelectStatement getRight() {
        return right;
    }
}
