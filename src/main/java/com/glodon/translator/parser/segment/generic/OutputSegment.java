package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.item.ColumnProjectionSegment;
import com.glodon.translator.parser.segment.generic.table.TableNameSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class OutputSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private TableNameSegment tableName;

    public void setTableName(TableNameSegment tableName) {
        this.tableName = tableName;
    }

    private final Collection<ColumnProjectionSegment> outputColumns = new LinkedList<>();

    private final Collection<ColumnSegment> tableColumns = new LinkedList<>();

    public OutputSegment(int startIndex, int stopIndex) {
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

    public TableNameSegment getTableName() {
        return tableName;
    }

    public Collection<ColumnProjectionSegment> getOutputColumns() {
        return outputColumns;
    }

    public Collection<ColumnSegment> getTableColumns() {
        return tableColumns;
    }
}
