
package com.glodon.translator.parser.value.literal;

public final class NullLiteralValue implements LiteralValue<String> {

    private final String value;

    public NullLiteralValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
