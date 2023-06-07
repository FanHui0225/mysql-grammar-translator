package com.glodon.translator.parser.dialect.mysql;

import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.ParseASTNode;
import com.glodon.translator.parser.SQLParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import com.glodon.translator.antlr4.MySQLStatementParser;

public final class MySQLParser extends MySQLStatementParser implements SQLParser {

    public MySQLParser(final TokenStream input) {
        super(input);
    }

    @Override
    public ASTNode parse() {
        return new ParseASTNode(execute(), (CommonTokenStream) getTokenStream());
    }
}
