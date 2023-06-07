
package com.glodon.translator.parser.dialect.mysql.statement.dal;


import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

public final class MySQLResetPersistStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private final boolean ifExists;

    private final IdentifierValue identifier;

    public MySQLResetPersistStatement(boolean ifExists, IdentifierValue identifier) {
        this.ifExists = ifExists;
        this.identifier = identifier;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public IdentifierValue getIdentifier() {
        return identifier;
    }
}
