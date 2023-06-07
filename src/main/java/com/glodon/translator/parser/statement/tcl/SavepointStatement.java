
package com.glodon.translator.parser.statement.tcl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class SavepointStatement extends AbstractSQLStatement implements TCLStatement {

    private String savepointName;

    public String getSavepointName() {
        return savepointName;
    }

    public void setSavepointName(String savepointName) {
        this.savepointName = savepointName;
    }
}
