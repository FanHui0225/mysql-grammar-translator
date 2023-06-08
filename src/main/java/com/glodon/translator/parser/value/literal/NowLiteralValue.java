package com.glodon.translator.parser.value.literal;

public class NowLiteralValue implements LiteralValue<String> {

    private final String value;

    public NowLiteralValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
