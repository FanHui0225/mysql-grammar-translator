package com.glodon.translator.parser.value.keyword;

import com.glodon.translator.parser.value.ValueASTNode;

public final class KeywordValue implements ValueASTNode<String> {

    private final String value;

    public KeywordValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
