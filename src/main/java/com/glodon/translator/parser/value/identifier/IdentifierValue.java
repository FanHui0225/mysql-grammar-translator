package com.glodon.translator.parser.value.identifier;

import com.glodon.translator.parser.enums.QuoteCharacter;
import com.glodon.translator.parser.util.SQLUtils;
import com.glodon.translator.parser.value.ValueASTNode;
import com.google.common.base.Strings;

public final class IdentifierValue implements ValueASTNode<String> {

    private final String value;

    private final QuoteCharacter quoteCharacter;

    public IdentifierValue(String value, QuoteCharacter quoteCharacter) {
        this.value = value;
        this.quoteCharacter = quoteCharacter;
    }

    public IdentifierValue(final String text) {
        this(SQLUtils.getExactlyValue(text), QuoteCharacter.getQuoteCharacter(text));
    }

    public IdentifierValue(final String text, final String reservedCharacters) {
        this(SQLUtils.getExactlyValue(text, reservedCharacters), QuoteCharacter.getQuoteCharacter(text));
    }

    public String getValueWithQuoteCharacters() {
        return null == value ? "" : quoteCharacter.wrap(value);
    }

    public static String getQuotedContent(final String text) {
        if (Strings.isNullOrEmpty(text)) {
            return text;
        }
        QuoteCharacter quoteCharacter = QuoteCharacter.getQuoteCharacter(text);
        if (QuoteCharacter.NONE == quoteCharacter) {
            return text.trim();
        }
        return text.substring(1, text.length() - 1);
    }

    @Override
    public String getValue() {
        return value;
    }

    public QuoteCharacter getQuoteCharacter() {
        return quoteCharacter;
    }
}
