package com.glodon.translator.parser.segment.dml.predicate;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class OrPredicateSegment implements SQLSegment {

    private final int startIndex = 0;

    private final int stopIndex = 0;

    private final Collection<AndPredicate> andPredicates = new LinkedList<>();

    public OrPredicateSegment() {
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<AndPredicate> getAndPredicates() {
        return andPredicates;
    }
}
