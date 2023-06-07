package com.glodon.translator.parser.dialect.mysql.visitor;

import com.glodon.translator.antlr4.MySQLStatementParser.*;
import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLCallStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLDoStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLLoadDataStatement;
import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLLoadXMLStatement;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.visitor.statement.type.DMLStatementVisitor;

import java.util.ArrayList;
import java.util.List;

public final class MySQLDMLStatementVisitor extends MySQLStatementVisitor implements DMLStatementVisitor {

    @Override
    public ASTNode visitCall(final CallContext ctx) {
        List<ExpressionSegment> params = new ArrayList<>();
        ctx.expr().forEach(each -> params.add((ExpressionSegment) visit(each)));
        return new MySQLCallStatement(ctx.identifier().getText(), params);
    }

    @Override
    public ASTNode visitDoStatement(final DoStatementContext ctx) {
        List<ExpressionSegment> params = new ArrayList<>();
        ctx.expr().forEach(each -> params.add((ExpressionSegment) visit(each)));
        return new MySQLDoStatement(params);
    }

    @Override
    public ASTNode visitLoadStatement(final LoadStatementContext ctx) {
        return null != ctx.loadDataStatement() ? visit(ctx.loadDataStatement()) : visit(ctx.loadXmlStatement());
    }

    @Override
    public ASTNode visitLoadDataStatement(final LoadDataStatementContext ctx) {
        return new MySQLLoadDataStatement((SimpleTableSegment) visit(ctx.tableName()));
    }

    @Override
    public ASTNode visitLoadXmlStatement(final LoadXmlStatementContext ctx) {
        return new MySQLLoadXMLStatement((SimpleTableSegment) visit(ctx.tableName()));
    }
}
