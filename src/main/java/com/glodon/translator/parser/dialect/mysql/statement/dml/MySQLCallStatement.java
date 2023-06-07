package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.statement.dml.CallStatement;

import java.util.List;

public final class MySQLCallStatement extends CallStatement implements MySQLStatement {

    private String procedureName;

    private List<ExpressionSegment> parameters;

    public MySQLCallStatement() {
    }

    public MySQLCallStatement(String procedureName, List<ExpressionSegment> parameters) {
        this.procedureName = procedureName;
        this.parameters = parameters;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public List<ExpressionSegment> getParameters() {
        return parameters;
    }
}
