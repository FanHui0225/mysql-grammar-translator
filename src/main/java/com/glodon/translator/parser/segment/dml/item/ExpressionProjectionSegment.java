package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.ComplexExpressionSegment;
import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;
import com.glodon.translator.parser.util.SQLUtils;

import java.util.Optional;

public final class ExpressionProjectionSegment implements ProjectionSegment, ComplexExpressionSegment, AliasAvailable {

    private final int startIndex;

    private final int stopIndex;

    private final String text;

    private final ExpressionSegment expr;

    private AliasSegment alias;

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public ExpressionProjectionSegment(final int startIndex, final int stopIndex, final String text) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.text = SQLUtils.getExpressionWithoutOutsideParentheses(text);
        this.expr = null;
    }

    public ExpressionProjectionSegment(final int startIndex, final int stopIndex, final String text, final ExpressionSegment expr) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.text = SQLUtils.getExpressionWithoutOutsideParentheses(text);
        this.expr = expr;
    }

    @Override
    public Optional<String> getAliasName() {
        return null == alias ? Optional.empty() : Optional.ofNullable(alias.getIdentifier().getValue());
    }

    @Override
    public Optional<AliasSegment> getAlias() {
        return Optional.ofNullable(alias);
    }

    @Override
    public int getStopIndex() {
        return null != alias ? alias.getStopIndex() : stopIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public String getText() {
        return text;
    }

    public ExpressionSegment getExpr() {
        return expr;
    }
}
