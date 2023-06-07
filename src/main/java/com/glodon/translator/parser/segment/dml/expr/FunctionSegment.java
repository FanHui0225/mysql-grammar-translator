package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;
import com.glodon.translator.parser.segment.generic.OwnerSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class FunctionSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String functionName;

    private final Collection<ExpressionSegment> parameters = new LinkedList<>();

    private final String text;

    private OwnerSegment owner;

    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }

    public FunctionSegment(int startIndex, int stopIndex, String functionName, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.text = text;
    }

    public FunctionSegment(int startIndex, int stopIndex, String functionName, String text, OwnerSegment owner) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.text = text;
        this.owner = owner;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Collection<ExpressionSegment> getParameters() {
        return parameters;
    }

    @Override
    public String getText() {
        return text;
    }

    public OwnerSegment getOwner() {
        return owner;
    }
}
