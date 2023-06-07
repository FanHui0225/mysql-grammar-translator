package com.glodon.translator.parser.dialect.mysql.statement.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.ddl.DropTableStatement;

public final class MySQLDropTableStatement extends DropTableStatement implements MySQLStatement {

    private final boolean ifExists;

    public MySQLDropTableStatement(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public boolean isIfExists() {
        return ifExists;
    }
}
