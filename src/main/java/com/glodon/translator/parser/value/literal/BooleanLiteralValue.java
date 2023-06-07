
package com.glodon.translator.parser.value.literal;

public final class BooleanLiteralValue implements LiteralValue<Boolean> {

    private final boolean value;

    public BooleanLiteralValue(boolean value) {
        this.value = value;
    }

    public BooleanLiteralValue(final String value) {
        this.value = Boolean.parseBoolean(value);
    }

    @Override
    public Boolean getValue() {
        return value;
    }
}
