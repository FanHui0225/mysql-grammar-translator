
package com.glodon.translator.parser.value.literal;


public final class OtherLiteralValue implements LiteralValue<String> {

    private final String value;

    public OtherLiteralValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
