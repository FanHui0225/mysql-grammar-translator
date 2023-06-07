
package com.glodon.translator.parser.segment.ddl.column.position;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

public final class ColumnFirstPositionSegment extends ColumnPositionSegment {

    public ColumnFirstPositionSegment(final int startIndex, final int stopIndex, final ColumnSegment columnName) {
        super(startIndex, stopIndex, columnName);
    }
}
