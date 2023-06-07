package com.glodon.translator.parser.statement.dal;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class UseStatement extends AbstractSQLStatement implements DALStatement {

    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
