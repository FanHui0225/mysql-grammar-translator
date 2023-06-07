package com.glodon.translator.parser.statement.tcl.xa;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public final class XAEndStatement extends AbstractSQLStatement implements XAStatement {

    private final String xid;

    public XAEndStatement(String xid) {
        this.xid = xid;
    }

    public String getXid() {
        return xid;
    }
}
