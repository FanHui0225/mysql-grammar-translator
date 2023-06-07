
package com.glodon.translator.parser.segment.dml.item;

import com.glodon.translator.parser.enums.AggregationType;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public class AggregationProjectionSegment implements ProjectionSegment, AliasAvailable, ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final AggregationType type;

    private final String innerExpression;

    private final Collection<ExpressionSegment> parameters = new LinkedList<>();

    private AliasSegment alias;

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public AggregationProjectionSegment(int startIndex, int stopIndex, AggregationType type, String innerExpression) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.type = type;
        this.innerExpression = innerExpression;
    }

    @Override
    public final Optional<String> getAliasName() {
        return null == alias ? Optional.empty() : Optional.ofNullable(alias.getIdentifier().getValue());
    }

    @Override
    public final Optional<AliasSegment> getAlias() {
        return Optional.ofNullable(alias);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public AggregationType getType() {
        return type;
    }

    public String getInnerExpression() {
        return innerExpression;
    }

    public Collection<ExpressionSegment> getParameters() {
        return parameters;
    }
}
