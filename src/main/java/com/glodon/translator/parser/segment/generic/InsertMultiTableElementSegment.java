package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.statement.dml.InsertStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class InsertMultiTableElementSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<InsertStatement> insertStatements = new LinkedList<>();

    public InsertMultiTableElementSegment(int startIndex, int stopIndex) {
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

    public Collection<InsertStatement> getInsertStatements() {
        return insertStatements;
    }
}
