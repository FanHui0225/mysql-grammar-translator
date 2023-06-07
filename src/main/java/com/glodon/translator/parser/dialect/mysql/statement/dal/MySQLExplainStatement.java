package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dal.ExplainStatement;

import java.util.Optional;

public final class MySQLExplainStatement extends ExplainStatement implements MySQLStatement {

    private SimpleTableSegment table;

    private ColumnSegment columnWild;

    public Optional<SimpleTableSegment> getTable() {
        return Optional.ofNullable(table);
    }

    public Optional<ColumnSegment> getColumnWild() {
        return Optional.ofNullable(columnWild);
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public void setColumnWild(ColumnSegment columnWild) {
        this.columnWild = columnWild;
    }
}
