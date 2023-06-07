package com.glodon.translator.parser.statement.tcl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class SetAutoCommitStatement extends AbstractSQLStatement implements TCLStatement {
    
    private boolean autoCommit;

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }
}
