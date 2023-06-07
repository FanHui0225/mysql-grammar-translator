package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

import java.util.Optional;

public final class VariableSegment implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String variable;

    private String scope;

    public VariableSegment(int startIndex, int stopIndex, String variable) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.variable = variable;
    }

    public VariableSegment(int startIndex, int stopIndex, String variable, String scope) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.variable = variable;
        this.scope = scope;
    }

    public Optional<String> getScope() {
        return Optional.ofNullable(scope);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public String getVariable() {
        return variable;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
