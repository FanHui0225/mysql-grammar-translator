package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public abstract class CreateSchemaStatement extends AbstractSQLStatement implements DDLStatement {

    private IdentifierValue schemaName;
    
    public Optional<IdentifierValue> getSchemaName() {
        return Optional.ofNullable(schemaName);
    }

    public void setSchemaName(IdentifierValue schemaName) {
        this.schemaName = schemaName;
    }
}
