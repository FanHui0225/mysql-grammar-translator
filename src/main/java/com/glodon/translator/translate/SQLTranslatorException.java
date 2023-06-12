package com.glodon.translator.translate;

public class SQLTranslatorException extends RuntimeException {

    public SQLTranslatorException(final String error) {
        super(String.format("You have an error in your SQL statement: %s", error));
    }
}
