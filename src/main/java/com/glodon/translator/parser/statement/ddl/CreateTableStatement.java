package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.ConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class CreateTableStatement extends AbstractSQLStatement implements DDLStatement {

    private SimpleTableSegment table;

    private final Collection<ColumnDefinitionSegment> columnDefinitions = new LinkedList<>();

    private final Collection<ConstraintDefinitionSegment> constraintDefinitions = new LinkedList<>();

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public Collection<ColumnDefinitionSegment> getColumnDefinitions() {
        return columnDefinitions;
    }

    public Collection<ConstraintDefinitionSegment> getConstraintDefinitions() {
        return constraintDefinitions;
    }
}
