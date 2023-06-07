package com.glodon.translator.parser.segment.ddl.column.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.position.ColumnPositionSegment;

import java.util.Optional;

public final class ModifyColumnDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ColumnDefinitionSegment columnDefinition;

    private ColumnPositionSegment columnPosition;

    public ModifyColumnDefinitionSegment(int startIndex, int stopIndex, ColumnDefinitionSegment columnDefinition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinition = columnDefinition;
    }

    public ModifyColumnDefinitionSegment(int startIndex, int stopIndex, ColumnDefinitionSegment columnDefinition, ColumnPositionSegment columnPosition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinition = columnDefinition;
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

    public ColumnDefinitionSegment getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnPosition(ColumnPositionSegment columnPosition) {
        this.columnPosition = columnPosition;
    }
}
