
package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.expr.FunctionSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowProcedureCodeStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private FunctionSegment function;

    public FunctionSegment getFunction() {
        return function;
    }

    public void setFunction(FunctionSegment function) {
        this.function = function;
    }
}
