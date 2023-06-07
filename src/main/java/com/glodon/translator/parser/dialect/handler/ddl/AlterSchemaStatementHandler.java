package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.statement.ddl.AlterSchemaStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public final class AlterSchemaStatementHandler implements SQLStatementHandler {

    private AlterSchemaStatementHandler() {
    }

    public static Optional<IdentifierValue> getRenameSchema(final AlterSchemaStatement alterSchemaStatement) {
        return Optional.empty();
    }
}
