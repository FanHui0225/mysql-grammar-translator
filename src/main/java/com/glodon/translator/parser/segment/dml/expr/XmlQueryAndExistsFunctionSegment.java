package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;
import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class XmlQueryAndExistsFunctionSegment implements ComplexExpressionSegment, ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String functionName;

    private final String xQueryString;

    private final Collection<ExpressionSegment> parameters = new LinkedList<>();

    private final String text;

    public XmlQueryAndExistsFunctionSegment(int startIndex, int stopIndex, String functionName, String xQueryString, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.xQueryString = xQueryString;
        this.text = text;
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

    public String getxQueryString() {
        return xQueryString;
    }

    public Collection<ExpressionSegment> getParameters() {
        return parameters;
    }

    @Override
    public String getText() {
        return text;
    }
}
