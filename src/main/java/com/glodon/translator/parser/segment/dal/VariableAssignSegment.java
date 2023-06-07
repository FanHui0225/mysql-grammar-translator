package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.SQLSegment;

public final class VariableAssignSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private VariableSegment variable;

    private String assignValue;

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

    public VariableSegment getVariable() {
        return variable;
    }

    public void setVariable(VariableSegment variable) {
        this.variable = variable;
    }

    public String getAssignValue() {
        return assignValue;
    }

    public void setAssignValue(String assignValue) {
        this.assignValue = assignValue;
    }
}
