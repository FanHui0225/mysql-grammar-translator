package com.glodon.translator.parser.segment.ddl.routine;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Collection;
import java.util.LinkedList;

public class RoutineBodySegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ValidStatementSegment> validStatements = new LinkedList<>();

    public RoutineBodySegment(int startIndex, int stopIndex) {
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

    public Collection<ValidStatementSegment> getValidStatements() {
        return validStatements;
    }
}
