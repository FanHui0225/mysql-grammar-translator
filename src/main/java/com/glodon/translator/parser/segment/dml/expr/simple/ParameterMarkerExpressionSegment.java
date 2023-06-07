package com.glodon.translator.parser.segment.dml.expr.simple;

import com.glodon.translator.parser.enums.ParameterMarkerType;
import com.glodon.translator.parser.segment.dml.item.ProjectionSegment;
import com.glodon.translator.parser.segment.generic.AliasAvailable;
import com.glodon.translator.parser.segment.generic.AliasSegment;
import com.glodon.translator.parser.segment.generic.ParameterMarkerSegment;

import java.util.Objects;
import java.util.Optional;

public class ParameterMarkerExpressionSegment implements SimpleExpressionSegment, ProjectionSegment, AliasAvailable, ParameterMarkerSegment {

    private final int startIndex;

    private final int stopIndex;

    private final int parameterMarkerIndex;

    private final ParameterMarkerType parameterMarkerType;

    private AliasSegment alias;

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public ParameterMarkerExpressionSegment(int startIndex, int stopIndex, int parameterMarkerIndex, ParameterMarkerType parameterMarkerType) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.parameterMarkerIndex = parameterMarkerIndex;
        this.parameterMarkerType = parameterMarkerType;
    }

    public ParameterMarkerExpressionSegment(final int startIndex, final int stopIndex, final int parameterMarkerIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.parameterMarkerIndex = parameterMarkerIndex;
        this.parameterMarkerType = ParameterMarkerType.QUESTION;
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
    public int getParameterIndex() {
        return parameterMarkerIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public int getParameterMarkerIndex() {
        return parameterMarkerIndex;
    }

    public ParameterMarkerType getParameterMarkerType() {
        return parameterMarkerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterMarkerExpressionSegment that = (ParameterMarkerExpressionSegment) o;
        return startIndex == that.startIndex && stopIndex == that.stopIndex && parameterMarkerIndex == that.parameterMarkerIndex && parameterMarkerType == that.parameterMarkerType && alias.equals(that.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, stopIndex, parameterMarkerIndex, parameterMarkerType, alias);
    }
}
