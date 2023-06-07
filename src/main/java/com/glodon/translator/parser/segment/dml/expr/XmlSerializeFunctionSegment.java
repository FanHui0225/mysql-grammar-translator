package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;
import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;

public final class XmlSerializeFunctionSegment implements ComplexExpressionSegment, ProjectionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String functionName;

    private final ExpressionSegment parameter;

    private final String dataType;

    private final String encoding;

    private final String version;

    private final String identSize;

    private final String text;

    public XmlSerializeFunctionSegment(int startIndex, int stopIndex, String functionName, ExpressionSegment parameter, String dataType, String encoding, String version, String identSize, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.functionName = functionName;
        this.parameter = parameter;
        this.dataType = dataType;
        this.encoding = encoding;
        this.version = version;
        this.identSize = identSize;
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

    public ExpressionSegment getParameter() {
        return parameter;
    }

    public String getDataType() {
        return dataType;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getVersion() {
        return version;
    }

    public String getIdentSize() {
        return identSize;
    }

    @Override
    public String getText() {
        return text;
    }
}
