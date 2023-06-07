package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Collection;
import java.util.LinkedList;

public abstract class DropSchemaStatement extends AbstractSQLStatement implements DDLStatement {

    private final Collection<IdentifierValue> schemaNames = new LinkedList<>();

    public Collection<IdentifierValue> getSchemaNames() {
        return schemaNames;
    }
}
