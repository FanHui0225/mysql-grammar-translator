package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class CommentStatement extends AbstractSQLStatement implements DDLStatement {

    private SimpleTableSegment table;

    private ColumnSegment column;

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public ColumnSegment getColumn() {
        return column;
    }

    public void setColumn(ColumnSegment column) {
        this.column = column;
    }
}
