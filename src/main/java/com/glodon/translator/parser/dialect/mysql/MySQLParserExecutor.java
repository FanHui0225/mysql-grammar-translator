package com.glodon.translator.parser.dialect.mysql;

import com.glodon.translator.parser.*;
import com.glodon.translator.parser.dialect.mysql.lexer.MySQLLexer;
import com.glodon.translator.parser.dialect.mysql.visitor.*;
import com.glodon.translator.parser.statement.SQLStatementType;
import com.glodon.translator.parser.visitor.statement.SQLStatementVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.nio.CharBuffer;

public final class MySQLParserExecutor extends SQLParserExecutor {

    protected SQLStatementVisitor createParseTreeVisitor(final SQLStatementType type) {
        switch (type) {
            case DML:
                return new MySQLDMLStatementVisitor();
            case DDL:
                return new MySQLDDLStatementVisitor();
            case TCL:
                return new MySQLTCLStatementVisitor();
            case DCL:
                return new MySQLDCLStatementVisitor();
            case DAL:
                return new MySQLDALStatementVisitor();
            case RL:
                return new MySQLRLStatementVisitor();
            default:
                throw new SQLParsingException(type.name());
        }
    }

    public ParseASTNode parseASTNode(final String sql) {
        CodePointBuffer buffer = CodePointBuffer.withChars(CharBuffer.wrap(sql.toCharArray()));
        MySQLLexer mySQLLexer = new MySQLLexer(CodePointCharStream.fromBuffer(buffer));
        SQLParser sqlParser = new MySQLParser(new CommonTokenStream(mySQLLexer));
        try {
            return (ParseASTNode) sqlParser.parse();
        } catch (final ParseCancellationException ex) {
            ((Parser) sqlParser).reset();
            ((Parser) sqlParser).getInterpreter().setPredictionMode(PredictionMode.LL);
            ((Parser) sqlParser).removeErrorListeners();
            ((Parser) sqlParser).addErrorListener(MySQLParserErrorListener.getInstance());
            try {
                return (ParseASTNode) sqlParser.parse();
            } catch (final ParseCancellationException e) {
                throw new SQLParsingException(sql + ", " + e.getMessage());
            }
        }
    }
}
