package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.routine.FunctionNameSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class CreateProcedureStatement extends AbstractSQLStatement implements DDLStatement {

    private FunctionNameSegment procedureName;

    public Optional<FunctionNameSegment> getProcedureName() {
        return Optional.ofNullable(procedureName);
    }

    public void setProcedureName(FunctionNameSegment procedureName) {
        this.procedureName = procedureName;
    }
}
