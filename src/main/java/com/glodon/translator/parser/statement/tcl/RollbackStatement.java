
package com.glodon.translator.parser.statement.tcl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class RollbackStatement extends AbstractSQLStatement implements TCLStatement {

    private String savepointName;

    public Optional<String> getSavepointName() {
        return Optional.ofNullable(savepointName);
    }

    public void setSavepointName(String savepointName) {
        this.savepointName = savepointName;
    }
}
