
package com.glodon.translator.parser.statement.tcl.xa;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public final class XABeginStatement extends AbstractSQLStatement implements XAStatement {

    private final String xid;

    public XABeginStatement(String xid) {
        this.xid = xid;
    }

    public String getXid() {
        return xid;
    }
}
