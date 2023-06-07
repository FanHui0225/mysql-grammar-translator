package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowCreateTriggerStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
