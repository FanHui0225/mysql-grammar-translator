package com.glodon.translator.parser.statement.dal;

import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.SQLStatement;

import java.util.Optional;

public abstract class ExplainStatement extends AbstractSQLStatement implements DALStatement {

    private SQLStatement statement;

    public Optional<SQLStatement> getStatement() {
        return Optional.ofNullable(statement);
    }


    public void setStatement(SQLStatement statement) {
        this.statement = statement;
    }
}
