package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.statement.ddl.DropSchemaStatement;

public final class DropSchemaStatementHandler implements SQLStatementHandler {

    private DropSchemaStatementHandler() {
    }

    public static boolean containsCascade(final DropSchemaStatement dropSchemaStatement) {
        return false;
    }
}
