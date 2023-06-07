package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.statement.dml.DoStatement;

import java.util.List;

public final class MySQLDoStatement extends DoStatement implements MySQLStatement {

    private List<ExpressionSegment> parameters;

    public MySQLDoStatement() {
    }

    public MySQLDoStatement(List<ExpressionSegment> parameters) {
        this.parameters = parameters;
    }

    public List<ExpressionSegment> getParameters() {
        return parameters;
    }
}
