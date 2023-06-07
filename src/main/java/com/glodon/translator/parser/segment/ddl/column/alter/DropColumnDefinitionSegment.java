package com.glodon.translator.parser.segment.ddl.column.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

import java.util.Collection;
import java.util.Objects;

public final class DropColumnDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ColumnSegment> columns;

    public DropColumnDefinitionSegment(int startIndex, int stopIndex, Collection<ColumnSegment> columns) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columns = columns;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ColumnSegment> getColumns() {
        return columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DropColumnDefinitionSegment that = (DropColumnDefinitionSegment) o;
        return startIndex == that.startIndex && stopIndex == that.stopIndex && columns.equals(that.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, stopIndex, columns);
    }
}
