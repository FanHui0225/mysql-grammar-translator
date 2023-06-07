package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class CreateIndexStatement extends AbstractSQLStatement implements DDLStatement {

    private IndexSegment index;

    private SimpleTableSegment table;

    private final Collection<ColumnSegment> columns = new LinkedList<>();

    public IndexSegment getIndex() {
        return index;
    }

    public void setIndex(IndexSegment index) {
        this.index = index;
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public Collection<ColumnSegment> getColumns() {
        return columns;
    }
}
