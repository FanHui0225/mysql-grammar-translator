package com.glodon.translator.parser;

public final class SQLParsingException extends RuntimeException {

    public SQLParsingException(final String sql) {
        super(String.format("You have an error in your SQL syntax: %s", sql));
    }
}
