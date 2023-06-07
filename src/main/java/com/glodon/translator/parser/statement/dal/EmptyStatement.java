package com.glodon.translator.parser.statement.dal;


import com.glodon.translator.parser.statement.AbstractSQLStatement;

public class EmptyStatement extends AbstractSQLStatement {

    @Override
    public int getParameterCount() {
        return 0;
    }
}
