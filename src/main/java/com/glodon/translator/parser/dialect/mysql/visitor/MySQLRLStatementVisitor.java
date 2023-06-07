package com.glodon.translator.parser.dialect.mysql.visitor;

import com.glodon.translator.antlr4.MySQLStatementParser.*;
import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.dialect.mysql.statement.rl.MySQLChangeMasterStatement;
import com.glodon.translator.parser.dialect.mysql.statement.rl.MySQLStartSlaveStatement;
import com.glodon.translator.parser.dialect.mysql.statement.rl.MySQLStopSlaveStatement;
import com.glodon.translator.parser.visitor.statement.type.RLStatementVisitor;

public final class MySQLRLStatementVisitor extends MySQLStatementVisitor implements RLStatementVisitor {

    @Override
    public ASTNode visitChangeMasterTo(final ChangeMasterToContext ctx) {
        return new MySQLChangeMasterStatement();
    }

    @Override
    public ASTNode visitStartSlave(final StartSlaveContext ctx) {
        return new MySQLStartSlaveStatement();
    }

    @Override
    public ASTNode visitStopSlave(final StopSlaveContext ctx) {
        return new MySQLStopSlaveStatement();
    }
}
