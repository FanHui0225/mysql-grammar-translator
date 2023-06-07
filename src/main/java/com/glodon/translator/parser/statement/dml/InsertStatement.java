package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.dml.assignment.InsertValuesSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.column.InsertColumnsSegment;
import com.glodon.translator.parser.segment.dml.expr.subquery.SubquerySegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public abstract class InsertStatement extends AbstractSQLStatement implements DMLStatement {

    private SimpleTableSegment table;

    private InsertColumnsSegment insertColumns;

    private SubquerySegment insertSelect;

    private final Collection<InsertValuesSegment> values = new LinkedList<>();

    public Optional<InsertColumnsSegment> getInsertColumns() {
        return Optional.ofNullable(insertColumns);
    }

    public Collection<ColumnSegment> getColumns() {
        return null == insertColumns ? Collections.emptyList() : insertColumns.getColumns();
    }

    public Optional<SubquerySegment> getInsertSelect() {
        return Optional.ofNullable(insertSelect);
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public void setInsertColumns(InsertColumnsSegment insertColumns) {
        this.insertColumns = insertColumns;
    }

    public void setInsertSelect(SubquerySegment insertSelect) {
        this.insertSelect = insertSelect;
    }

    public Collection<InsertValuesSegment> getValues() {
        return values;
    }
}
