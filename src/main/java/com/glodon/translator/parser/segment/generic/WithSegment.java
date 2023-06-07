
package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.CommonTableExpressionSegment;

import java.util.Collection;

public final class WithSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<CommonTableExpressionSegment> commonTableExpressions;

    public WithSegment(int startIndex, int stopIndex, Collection<CommonTableExpressionSegment> commonTableExpressions) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.commonTableExpressions = commonTableExpressions;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<CommonTableExpressionSegment> getCommonTableExpressions() {
        return commonTableExpressions;
    }
}
