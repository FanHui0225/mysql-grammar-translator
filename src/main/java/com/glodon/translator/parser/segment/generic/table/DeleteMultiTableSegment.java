package com.glodon.translator.parser.segment.generic.table;

import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class DeleteMultiTableSegment implements TableSegment {

    private int startIndex;

    private int stopIndex;

    private List<SimpleTableSegment> actualDeleteTables = new LinkedList<>();

    private TableSegment relationTable;

    @Override
    public Optional<String> getAliasName() {
        return Optional.empty();
    }

    @Override
    public Optional<AliasSegment> getAlias() {
        return Optional.empty();
    }

    @Override
    public void setAlias(final AliasSegment alias) {
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public List<SimpleTableSegment> getActualDeleteTables() {
        return actualDeleteTables;
    }

    public void setActualDeleteTables(List<SimpleTableSegment> actualDeleteTables) {
        this.actualDeleteTables = actualDeleteTables;
    }

    public TableSegment getRelationTable() {
        return relationTable;
    }

    public void setRelationTable(TableSegment relationTable) {
        this.relationTable = relationTable;
    }
}
