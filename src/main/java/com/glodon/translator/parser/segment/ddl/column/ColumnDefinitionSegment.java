package com.glodon.translator.parser.segment.ddl.column;

import com.glodon.translator.parser.segment.ddl.CreateDefinitionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.DataTypeSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

import java.util.Collection;
import java.util.LinkedList;

public final class ColumnDefinitionSegment implements CreateDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ColumnSegment columnName;

    private final DataTypeSegment dataType;

    private final boolean primaryKey;

    private final boolean notNull;

    private final Collection<SimpleTableSegment> referencedTables = new LinkedList<>();

    public ColumnDefinitionSegment(int startIndex, int stopIndex, ColumnSegment columnName, DataTypeSegment dataType, boolean primaryKey, boolean notNull) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnName = columnName;
        this.dataType = dataType;
        this.primaryKey = primaryKey;
        this.notNull = notNull;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public ColumnSegment getColumnName() {
        return columnName;
    }

    public DataTypeSegment getDataType() {
        return dataType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public Collection<SimpleTableSegment> getReferencedTables() {
        return referencedTables;
    }
}
