
package com.glodon.translator.parser.segment.ddl.column.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;

public final class RenameColumnSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ColumnSegment oldColumnName;

    private final ColumnSegment columnName;

    public RenameColumnSegment(int startIndex, int stopIndex, ColumnSegment oldColumnName, ColumnSegment columnName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.oldColumnName = oldColumnName;
        this.columnName = columnName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public ColumnSegment getOldColumnName() {
        return oldColumnName;
    }

    public ColumnSegment getColumnName() {
        return columnName;
    }
}
