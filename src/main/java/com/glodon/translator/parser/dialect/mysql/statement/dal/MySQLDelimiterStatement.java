package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLDelimiterStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String delimiterName;

    public String getDelimiterName() {
        return delimiterName;
    }

    public void setDelimiterName(String delimiterName) {
        this.delimiterName = delimiterName;
    }
}
