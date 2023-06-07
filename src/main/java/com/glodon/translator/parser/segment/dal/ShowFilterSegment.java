package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.predicate.WhereSegment;

import java.util.Optional;

public final class ShowFilterSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private ShowLikeSegment like;

    private WhereSegment where;

    public ShowFilterSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public ShowFilterSegment(int startIndex, int stopIndex, ShowLikeSegment like, WhereSegment where) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.like = like;
        this.where = where;
    }

    public Optional<ShowLikeSegment> getLike() {
        return Optional.ofNullable(like);
    }

    public Optional<WhereSegment> getWhere() {
        return Optional.ofNullable(where);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setLike(ShowLikeSegment like) {
        this.like = like;
    }

    public void setWhere(WhereSegment where) {
        this.where = where;
    }
}
