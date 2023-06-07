package com.glodon.translator.parser.segment.dml.expr;

import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;

public final class TypeCastExpression implements ComplexExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String text;

    private final ExpressionSegment expression;

    private final String dataType;

    public TypeCastExpression(int startIndex, int stopIndex, String text, ExpressionSegment expression, String dataType) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.text = text;
        this.expression = expression;
        this.dataType = dataType;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public String getText() {
        return text;
    }

    public ExpressionSegment getExpression() {
        return expression;
    }

    public String getDataType() {
        return dataType;
    }
}
