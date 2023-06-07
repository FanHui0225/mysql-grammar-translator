package com.glodon.translator.parser.statement.dal;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class ResetParameterStatement extends AbstractSQLStatement implements DALStatement {

    private final String configurationParameter;

    public ResetParameterStatement(String configurationParameter) {
        this.configurationParameter = configurationParameter;
    }

    public String getConfigurationParameter() {
        return configurationParameter;
    }
}
