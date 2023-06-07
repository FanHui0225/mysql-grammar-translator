package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class PartitionDefinitionSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final SimpleTableSegment table;

    private final Collection<PartitionSegment> partitions = new LinkedList<>();

    public PartitionDefinitionSegment(int startIndex, int stopIndex, SimpleTableSegment table) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.table = table;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public Collection<PartitionSegment> getPartitions() {
        return partitions;
    }
}
