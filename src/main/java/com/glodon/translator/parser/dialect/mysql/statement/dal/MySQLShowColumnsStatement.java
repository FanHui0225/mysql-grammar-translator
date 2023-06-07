package com.glodon.translator.parser.dialect.mysql.statement.dal;


import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dal.FromSchemaSegment;
import com.glodon.translator.parser.segment.dal.ShowFilterSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.Optional;

public final class MySQLShowColumnsStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private SimpleTableSegment table;

    private FromSchemaSegment fromSchema;

    private ShowFilterSegment filter;

    public Optional<FromSchemaSegment> getFromSchema() {
        return Optional.ofNullable(fromSchema);
    }

    public Optional<ShowFilterSegment> getFilter() {
        return Optional.ofNullable(filter);
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public void setFromSchema(FromSchemaSegment fromSchema) {
        this.fromSchema = fromSchema;
    }

    public void setFilter(ShowFilterSegment filter) {
        this.filter = filter;
    }
}
