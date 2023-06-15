package com.glodon.translator;

import com.glodon.translator.parser.ParseASTNode;
import com.glodon.translator.parser.SQLParser;
import com.glodon.translator.parser.SQLParsingException;
import com.glodon.translator.parser.dialect.mysql.MySQLParser;
import com.glodon.translator.parser.dialect.mysql.MySQLParserErrorListener;
import com.glodon.translator.parser.dialect.mysql.lexer.MySQLLexer;
import com.glodon.translator.parser.dialect.mysql.visitor.*;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.SQLStatementType;
import com.glodon.translator.parser.visitor.statement.SQLStatementVisitor;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslateExecutor;
import com.glodon.translator.translate.dameng.DamengStatementTranslatorFactory;
import org.antlr.v4.runtime.CodePointBuffer;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.nio.CharBuffer;

public class MySQLToDamengSQLFacade extends SQLTranslateExecutor {

    private final DamengStatementTranslatorFactory factory = new DamengStatementTranslatorFactory();

    @Override
    protected ParseASTNode parseASTNode(final String sql) {
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

    @Override
    protected SQLStatementVisitor createParseTreeVisitor(SQLStatementType type) {
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

    @Override
    protected SQLStatementTranslator<SQLStatement> makeSQLStatementTranslator(SQLStatement statement) {
        return factory.create(statement);
    }
}
