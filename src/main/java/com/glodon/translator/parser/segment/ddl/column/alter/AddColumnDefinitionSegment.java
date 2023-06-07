package com.glodon.translator.parser.segment.ddl.column.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.position.ColumnPositionSegment;

import java.util.Collection;
import java.util.Optional;

public final class AddColumnDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ColumnDefinitionSegment> columnDefinitions;

    private ColumnPositionSegment columnPosition;

    public AddColumnDefinitionSegment(int startIndex, int stopIndex, Collection<ColumnDefinitionSegment> columnDefinitions) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinitions = columnDefinitions;
    }

    public AddColumnDefinitionSegment(int startIndex, int stopIndex, Collection<ColumnDefinitionSegment> columnDefinitions, ColumnPositionSegment columnPosition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinitions = columnDefinitions;
        this.columnPosition = columnPosition;
    }

    public Optional<ColumnPositionSegment> getColumnPosition() {
        return Optional.ofNullable(columnPosition);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ColumnDefinitionSegment> getColumnDefinitions() {
        return columnDefinitions;
    }

    public void setColumnPosition(ColumnPositionSegment columnPosition) {
        this.columnPosition = columnPosition;
    }
}
