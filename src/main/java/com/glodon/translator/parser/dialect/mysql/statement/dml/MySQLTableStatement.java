package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dml.TableStatement;

public final class MySQLTableStatement extends TableStatement implements MySQLStatement {

    private SimpleTableSegment table;

    private ColumnSegment column;

    private LimitSegment limit;

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

    public LimitSegment getLimit() {
        return limit;
    }

    public void setLimit(LimitSegment limit) {
        this.limit = limit;
    }
}
