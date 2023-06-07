
package com.glodon.translator.parser.segment.dml.order.item;

import com.glodon.translator.parser.enums.NullsOrderType;
import com.glodon.translator.parser.enums.OrderDirection;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

public final class ExpressionOrderByItemSegment extends TextOrderByItemSegment {

    private final String expression;

    private final ExpressionSegment expr;

    public ExpressionOrderByItemSegment(final int startIndex, final int stopIndex, final String expression, final OrderDirection orderDirection, final NullsOrderType nullsOrderType) {
        super(startIndex, stopIndex, orderDirection, nullsOrderType);
        this.expression = expression;
        this.expr = null;
    }

    public ExpressionOrderByItemSegment(final int startIndex, final int stopIndex, final String expression, final OrderDirection orderDirection, final NullsOrderType nullsOrderType,
                                        final ExpressionSegment expr) {
        super(startIndex, stopIndex, orderDirection, nullsOrderType);
        this.expression = expression;
        this.expr = expr;
    }

    @Override
    public String getText() {
        return expression;
    }

    public String getExpression() {
        return expression;
    }

    public ExpressionSegment getExpr() {
        return expr;
    }
}
