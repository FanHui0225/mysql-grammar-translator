package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;

public final class XmlPiFunctionSegment implements ExpressionSegment, ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String functionName;

    private final String identifier;

    private final ExpressionSegment evalNameValueExpr;

    private final ExpressionSegment valueExpr;

    private final String text;

    public XmlPiFunctionSegment(final int startIndex, final int stopIndex, final String functionName, final String identifier, final ExpressionSegment valueExpr, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.evalNameValueExpr = null;
        this.identifier = identifier;
        this.valueExpr = valueExpr;
        this.text = text;
    }

    public XmlPiFunctionSegment(final int startIndex, final int stopIndex, final String functionName, final ExpressionSegment evalNameValueExpr, final ExpressionSegment valueExpr, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.identifier = null;
        this.evalNameValueExpr = evalNameValueExpr;
        this.valueExpr = valueExpr;
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

    public String getIdentifier() {
        return identifier;
    }

    public ExpressionSegment getEvalNameValueExpr() {
        return evalNameValueExpr;
    }

    public ExpressionSegment getValueExpr() {
        return valueExpr;
    }

    public String getText() {
        return text;
    }
}
