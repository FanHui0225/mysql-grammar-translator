
package com.glodon.translator.parser.statement;

import com.glodon.translator.parser.segment.generic.CommentSegment;
import com.glodon.translator.parser.segment.generic.ParameterMarkerSegment;

import java.util.Collection;
import java.util.LinkedList;

public abstract class AbstractSQLStatement implements SQLStatement {

    private final Collection<ParameterMarkerSegment> parameterMarkerSegments = new LinkedList<>();

    private final Collection<CommentSegment> commentSegments = new LinkedList<>();

    @Override
    public int getParameterCount() {
        return (int) parameterMarkerSegments.stream().map(ParameterMarkerSegment::getParameterIndex).distinct().count();
    }

    public Collection<ParameterMarkerSegment> getParameterMarkerSegments() {
        return parameterMarkerSegments;
    }

    public Collection<CommentSegment> getCommentSegments() {
        return commentSegments;
    }
}
