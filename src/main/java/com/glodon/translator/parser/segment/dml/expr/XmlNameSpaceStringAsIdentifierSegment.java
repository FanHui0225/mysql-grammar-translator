package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;

public final class XmlNameSpaceStringAsIdentifierSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String xmlNameSpaceString;

    private final String xmlNameSpaceIdentifier;

    private final String text;

    public XmlNameSpaceStringAsIdentifierSegment(int startIndex, int stopIndex, String xmlNameSpaceString, String xmlNameSpaceIdentifier, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.xmlNameSpaceString = xmlNameSpaceString;
        this.xmlNameSpaceIdentifier = xmlNameSpaceIdentifier;
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

    public String getXmlNameSpaceString() {
        return xmlNameSpaceString;
    }

    public String getXmlNameSpaceIdentifier() {
        return xmlNameSpaceIdentifier;
    }

    @Override
    public String getText() {
        return text;
    }
}
