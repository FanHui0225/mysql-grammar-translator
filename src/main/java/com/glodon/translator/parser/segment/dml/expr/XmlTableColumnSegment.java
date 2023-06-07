package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;

public final class XmlTableColumnSegment implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String columnName;

    private final String dataType;

    private final String path;

    private final ExpressionSegment defaultExpr;

    private final String text;

    public XmlTableColumnSegment(int startIndex, int stopIndex, String columnName, String dataType, String path, ExpressionSegment defaultExpr, String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnName = columnName;
        this.dataType = dataType;
        this.path = path;
        this.defaultExpr = defaultExpr;
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

    public String getColumnName() {
        return columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getPath() {
        return path;
    }

    public ExpressionSegment getDefaultExpr() {
        return defaultExpr;
    }

    @Override
    public String getText() {
        return text;
    }
}
