package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class AlterSequenceStatement extends AbstractSQLStatement implements DDLStatement {

    private String sequenceName;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }
}
