package com.glodon.translator.parser.dialect.mysql;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public final class MySQLParserErrorListener extends BaseErrorListener {

    private static final MySQLParserErrorListener INSTANCE = new MySQLParserErrorListener();

    public static MySQLParserErrorListener getInstance() {
        return INSTANCE;
    }

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line, final int charPositionInLine,
                            final String message, final RecognitionException e) {
        throw new ParseCancellationException(message + " at line " + line + ", position " + charPositionInLine + ", near " + offendingSymbol);
    }
}