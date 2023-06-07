package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dal.FromSchemaSegment;
import com.glodon.translator.parser.segment.dal.ShowFilterSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.Optional;

public final class MySQLShowTableStatusStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private FromSchemaSegment fromSchema;

    private ShowFilterSegment filter;

    public Optional<FromSchemaSegment> getFromSchema() {
        return Optional.ofNullable(fromSchema);
    }

    public Optional<ShowFilterSegment> getFilter() {
        return Optional.ofNullable(filter);
    }

    public void setFromSchema(FromSchemaSegment fromSchema) {
        this.fromSchema = fromSchema;
    }

    public void setFilter(ShowFilterSegment filter) {
        this.filter = filter;
    }
}
