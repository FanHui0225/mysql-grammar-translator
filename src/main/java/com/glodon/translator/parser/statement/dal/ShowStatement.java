package com.glodon.translator.parser.statement.dal;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class ShowStatement extends AbstractSQLStatement implements DALStatement {

    private final String name;

    public ShowStatement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
