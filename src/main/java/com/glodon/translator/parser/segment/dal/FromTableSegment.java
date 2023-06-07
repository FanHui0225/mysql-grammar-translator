
package com.glodon.translator.parser.segment.dal;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

public final class FromTableSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private SimpleTableSegment table;

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }
}
