
package com.glodon.translator.parser.segment.dml.order.item;

import com.glodon.translator.parser.enums.NullsOrderType;
import com.glodon.translator.parser.enums.OrderDirection;

public final class IndexOrderByItemSegment extends OrderByItemSegment {
    
    private final int columnIndex;
    
    public IndexOrderByItemSegment(final int startIndex, final int stopIndex, final int columnIndex, final OrderDirection orderDirection, final NullsOrderType nullsOrderType) {
        super(startIndex, stopIndex, orderDirection, nullsOrderType);
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
