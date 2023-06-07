package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowEngineStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String engineName;

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
}
