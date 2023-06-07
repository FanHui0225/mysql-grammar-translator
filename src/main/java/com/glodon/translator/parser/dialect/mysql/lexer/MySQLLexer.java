
package com.glodon.translator.parser.dialect.mysql.lexer;
import com.glodon.translator.antlr4.MySQLStatementLexer;
import com.glodon.translator.parser.SQLLexer;
import org.antlr.v4.runtime.CharStream;

public final class MySQLLexer extends MySQLStatementLexer implements SQLLexer {

    public MySQLLexer(final CharStream input) {
        super(input);
    }
}
