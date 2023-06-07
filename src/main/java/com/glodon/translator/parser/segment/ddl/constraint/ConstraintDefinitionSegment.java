package com.glodon.translator.parser.segment.ddl.constraint;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.CreateDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public final class ConstraintDefinitionSegment implements CreateDefinitionSegment, AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final Collection<ColumnSegment> primaryKeyColumns = new LinkedList<>();

    private final Collection<ColumnSegment> indexColumns = new LinkedList<>();

    private ConstraintSegment constraintName;

    private IndexSegment indexName;

    private SimpleTableSegment referencedTable;

    public ConstraintDefinitionSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public ConstraintDefinitionSegment(int startIndex, int stopIndex, ConstraintSegment constraintName, IndexSegment indexName, SimpleTableSegment referencedTable) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.constraintName = constraintName;
        this.indexName = indexName;
        this.referencedTable = referencedTable;
    }

    public Optional<ConstraintSegment> getConstraintName() {
        return Optional.ofNullable(constraintName);
    }

    public Optional<IndexSegment> getIndexName() {
        return Optional.ofNullable(indexName);
    }

    public Optional<SimpleTableSegment> getReferencedTable() {
        return Optional.ofNullable(referencedTable);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public Collection<ColumnSegment> getPrimaryKeyColumns() {
        return primaryKeyColumns;
    }

    public Collection<ColumnSegment> getIndexColumns() {
        return indexColumns;
    }

    public void setConstraintName(ConstraintSegment constraintName) {
        this.constraintName = constraintName;
    }

    public void setIndexName(IndexSegment indexName) {
        this.indexName = indexName;
    }

    public void setReferencedTable(SimpleTableSegment referencedTable) {
        this.referencedTable = referencedTable;
    }
}
