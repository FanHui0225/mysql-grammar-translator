package com.glodon.translator.parser.segment.dml.predicate;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

import java.util.LinkedList;
import java.util.List;

public final class LockSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final List<SimpleTableSegment> tables = new LinkedList<>();

    private final List<ColumnSegment> columns = new LinkedList<>();

    public LockSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public List<SimpleTableSegment> getTables() {
        return tables;
    }

    public List<ColumnSegment> getColumns() {
        return columns;
    }
}
