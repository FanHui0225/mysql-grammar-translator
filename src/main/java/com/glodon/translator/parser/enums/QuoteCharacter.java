
package com.glodon.translator.parser.enums;

import com.google.common.base.Strings;
import java.util.Arrays;

public enum QuoteCharacter {

    BACK_QUOTE("`", "`"),

    SINGLE_QUOTE("'", "'"),

    QUOTE("\"", "\""),

    BRACKETS("[", "]"),

    PARENTHESES("(", ")"),

    NONE("", "");

    private final String startDelimiter;

    private final String endDelimiter;

    QuoteCharacter(String startDelimiter, String endDelimiter) {
        this.startDelimiter = startDelimiter;
        this.endDelimiter = endDelimiter;
    }

    public static QuoteCharacter getQuoteCharacter(final String value) {
        if (Strings.isNullOrEmpty(value)) {
            return NONE;
        }
        return Arrays.stream(values()).filter(each -> NONE != each && each.startDelimiter.charAt(0) == value.charAt(0)).findFirst().orElse(NONE);
    }

    public String wrap(final String value) {
        return startDelimiter + value + endDelimiter;
    }

    public boolean isWrapped(final String value) {
        return value.startsWith(startDelimiter) && value.endsWith(endDelimiter);
    }
}
