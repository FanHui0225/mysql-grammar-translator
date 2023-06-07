package com.glodon.translator.parser.statement.tcl;

import com.glodon.translator.parser.enums.OperationScope;
import com.glodon.translator.parser.enums.TransactionAccessType;
import com.glodon.translator.parser.enums.TransactionIsolationLevel;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class SetTransactionStatement extends AbstractSQLStatement implements TCLStatement {

    private TransactionIsolationLevel isolationLevel;

    private OperationScope scope;

    private TransactionAccessType accessMode;

    public Optional<TransactionIsolationLevel> getIsolationLevel() {
        return Optional.ofNullable(isolationLevel);
    }

    public Optional<TransactionAccessType> getAccessMode() {
        return Optional.ofNullable(accessMode);
    }

    public void setIsolationLevel(TransactionIsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public OperationScope getScope() {
        return scope;
    }

    public void setScope(OperationScope scope) {
        this.scope = scope;
    }

    public void setAccessMode(TransactionAccessType accessMode) {
        this.accessMode = accessMode;
    }
}
