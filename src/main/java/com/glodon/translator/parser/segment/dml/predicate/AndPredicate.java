package com.glodon.translator.parser.segment.dml.predicate;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class AndPredicate implements SQLSegment {

    private final int startIndex = 0;

    private final int stopIndex = 0;

    private final Collection<ExpressionSegment> predicates = new LinkedList<>();

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ExpressionSegment> getPredicates() {
        return predicates;
    }
}
