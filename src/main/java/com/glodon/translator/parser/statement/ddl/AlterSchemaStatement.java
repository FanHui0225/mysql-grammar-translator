package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

public abstract class AlterSchemaStatement extends AbstractSQLStatement implements DDLStatement {

    private IdentifierValue schemaName;

    public IdentifierValue getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(IdentifierValue schemaName) {
        this.schemaName = schemaName;
    }
}
