
package com.glodon.translator.parser.segment.dml.expr.complex;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Collection;
import java.util.LinkedList;

public final class CommonTableExpressionSegment implements ExpressionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue identifier;

    private final SubquerySegment subquery;

    private final Collection<ColumnSegment> columns = new LinkedList<>();

    public CommonTableExpressionSegment(int startIndex, int stopIndex, IdentifierValue identifier, SubquerySegment subquery) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
        this.subquery = subquery;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public IdentifierValue getIdentifier() {
        return identifier;
    }

    public SubquerySegment getSubquery() {
        return subquery;
    }

    public Collection<ColumnSegment> getColumns() {
        return columns;
    }
}
