package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;
import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;

public final class XmlTableFunctionSegment implements ComplexExpressionSegment, ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String functionName;

    private final XmlNameSpacesClauseSegment xmlNameSpacesClause;

    private final String xQueryString;

    private final XmlTableOptionsSegment xmlTableOption;

    private final String text;

    public XmlTableFunctionSegment(int startIndex, int stopIndex, String functionName, XmlNameSpacesClauseSegment xmlNameSpacesClause, String xQueryString, XmlTableOptionsSegment xmlTableOption, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.xmlNameSpacesClause = xmlNameSpacesClause;
        this.xQueryString = xQueryString;
        this.xmlTableOption = xmlTableOption;
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

    public XmlNameSpacesClauseSegment getXmlNameSpacesClause() {
        return xmlNameSpacesClause;
    }

    public String getxQueryString() {
        return xQueryString;
    }

    public XmlTableOptionsSegment getXmlTableOption() {
        return xmlTableOption;
    }

    @Override
    public String getText() {
        return text;
    }
}
