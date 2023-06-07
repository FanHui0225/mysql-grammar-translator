package com.glodon.translator.parser.enums;

public enum OperationScope {

    GLOBAL("GLOBAL"),
    SESSION("SESSION");

    private final String scope;

    OperationScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }
}
