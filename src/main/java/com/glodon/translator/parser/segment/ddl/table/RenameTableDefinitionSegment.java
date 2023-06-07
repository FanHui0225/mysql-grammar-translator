package com.glodon.translator.parser.segment.ddl.table;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

public final class RenameTableDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private SimpleTableSegment table;

    private SimpleTableSegment renameTable;

    public RenameTableDefinitionSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public SimpleTableSegment getRenameTable() {
        return renameTable;
    }

    public void setRenameTable(SimpleTableSegment renameTable) {
        this.renameTable = renameTable;
    }
}
