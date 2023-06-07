package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLBinlogStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {
    
    private final String base64Str;

    public MySQLBinlogStatement(String base64Str) {
        this.base64Str = base64Str;
    }

    public String getBase64Str() {
        return base64Str;
    }
}
