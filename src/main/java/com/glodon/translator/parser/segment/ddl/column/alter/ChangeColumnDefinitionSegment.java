
package com.glodon.translator.parser.segment.ddl.column.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.position.ColumnPositionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

import java.util.Optional;

public final class ChangeColumnDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ColumnDefinitionSegment columnDefinition;

    private ColumnSegment previousColumn;

    private ColumnPositionSegment columnPosition;

    public ChangeColumnDefinitionSegment(int startIndex, int stopIndex, ColumnDefinitionSegment columnDefinition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinition = columnDefinition;
    }

    public ChangeColumnDefinitionSegment(int startIndex, int stopIndex, ColumnDefinitionSegment columnDefinition, ColumnSegment previousColumn, ColumnPositionSegment columnPosition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.columnDefinition = columnDefinition;
        this.previousColumn = previousColumn;
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

    public ColumnSegment getPreviousColumn() {
        return previousColumn;
    }

    public void setPreviousColumn(ColumnSegment previousColumn) {
        this.previousColumn = previousColumn;
    }

    public void setColumnPosition(ColumnPositionSegment columnPosition) {
        this.columnPosition = columnPosition;
    }
}
