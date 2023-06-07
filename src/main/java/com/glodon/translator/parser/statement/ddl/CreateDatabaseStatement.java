package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class CreateDatabaseStatement extends AbstractSQLStatement implements DDLStatement {

    private String databaseName;

    private boolean ifNotExists;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }
}
