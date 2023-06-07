package com.glodon.translator.parser.value.literal;

import org.apache.groovy.parser.antlr4.util.StringUtils;

public final class StringLiteralValue implements LiteralValue<String> {

    private final String value;

    public StringLiteralValue(final String value) {
        this.value = value.substring(1, value.length() - 1);
    }

    public static StringLiteralValue getStandardEscapesStringLiteralValue(final String value) {
        return new StringLiteralValue(StringUtils.replaceStandardEscapes(value));
    }

    @Override
    public String getValue() {
        return value;
    }
}
