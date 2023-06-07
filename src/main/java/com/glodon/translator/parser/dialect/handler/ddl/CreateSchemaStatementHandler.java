package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.statement.ddl.CreateSchemaStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public final class CreateSchemaStatementHandler implements SQLStatementHandler {

    private CreateSchemaStatementHandler() {
    }

    public static Optional<IdentifierValue> getUsername(final CreateSchemaStatement createSchemaStatement) {
        return Optional.empty();
    }
}
