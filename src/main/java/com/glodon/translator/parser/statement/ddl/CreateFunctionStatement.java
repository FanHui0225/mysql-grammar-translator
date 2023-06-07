package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.routine.FunctionNameSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class CreateFunctionStatement extends AbstractSQLStatement implements DDLStatement {

    private FunctionNameSegment functionName;

    public Optional<FunctionNameSegment> getFunctionName() {
        return Optional.ofNullable(functionName);
    }

    public void setFunctionName(FunctionNameSegment functionName) {
        this.functionName = functionName;
    }
}
