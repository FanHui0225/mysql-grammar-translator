package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class XmlTableOptionsSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ExpressionSegment> parameters = new LinkedList<>();

    private final Collection<XmlTableColumnSegment> xmlTableColumnSegments = new LinkedList<>();

    private final String text;

    public XmlTableOptionsSegment(int startIndex, int stopIndex, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
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

    public Collection<ExpressionSegment> getParameters() {
        return parameters;
    }

    public Collection<XmlTableColumnSegment> getXmlTableColumnSegments() {
        return xmlTableColumnSegments;
    }

    @Override
    public String getText() {
        return text;
    }
}
