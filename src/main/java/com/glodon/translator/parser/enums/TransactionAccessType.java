
package com.glodon.translator.parser.enums;

public enum TransactionAccessType {

    READ_ONLY("READ_ONLY"),
    READ_WRITE("READ_WRITE");

    private final String accessType;

    TransactionAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getAccessType() {
        return accessType;
    }
}
