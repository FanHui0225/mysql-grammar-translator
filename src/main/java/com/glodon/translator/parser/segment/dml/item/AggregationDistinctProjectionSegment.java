
package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.enums.AggregationType;
import com.glodon.translator.parser.util.SQLUtils;

public final class AggregationDistinctProjectionSegment extends AggregationProjectionSegment {

    private final String distinctExpression;

    public AggregationDistinctProjectionSegment(final int startIndex, final int stopIndex, final AggregationType type, final String innerExpression, final String distinctExpression) {
        super(startIndex, stopIndex, type, innerExpression);
        this.distinctExpression = SQLUtils.getExpressionWithoutOutsideParentheses(distinctExpression);
    }
}
