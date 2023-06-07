package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;

public abstract class DropSequenceStatement extends AbstractSQLStatement implements DDLStatement {

    private Collection<String> sequenceNames;

    public Collection<String> getSequenceNames() {
        return sequenceNames;
    }

    public void setSequenceNames(Collection<String> sequenceNames) {
        this.sequenceNames = sequenceNames;
    }
}
