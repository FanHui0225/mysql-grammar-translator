package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class XmlNameSpacesClauseSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String defaultString;

    private final Collection<XmlNameSpaceStringAsIdentifierSegment> stringAsIdentifier = new LinkedList<>();

    private final String text;

    public XmlNameSpacesClauseSegment(int startIndex, int stopIndex, String defaultString, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.defaultString = defaultString;
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

    public String getDefaultString() {
        return defaultString;
    }

    public Collection<XmlNameSpaceStringAsIdentifierSegment> getStringAsIdentifier() {
        return stringAsIdentifier;
    }

    @Override
    public String getText() {
        return text;
    }
}
