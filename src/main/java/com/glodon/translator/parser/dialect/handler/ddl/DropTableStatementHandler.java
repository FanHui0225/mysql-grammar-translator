package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLDropTableStatement;
import com.glodon.translator.parser.statement.ddl.DropTableStatement;

public final class DropTableStatementHandler implements SQLStatementHandler {

    private DropTableStatementHandler() {
    }

    public static boolean ifExists(final DropTableStatement dropTableStatement) {
        if (dropTableStatement instanceof MySQLStatement) {
            return ((MySQLDropTableStatement) dropTableStatement).isIfExists();
        }
        return false;
    }

    public static boolean containsCascade(final DropTableStatement dropTableStatement) {
        return false;
    }
}
