
package com.glodon.translator.parser.enums;

public enum TransactionIsolationLevel {

    NONE("NONE"),
    READ_UNCOMMITTED("READ-UNCOMMITTED"),
    READ_COMMITTED("READ-COMMITTED"),
    REPEATABLE_READ("REPEATABLE-READ"),
    SNAPSHOT("SNAPSHOT"),
    SERIALIZABLE("SERIALIZABLE");

    private final String isolationLevel;


    TransactionIsolationLevel(String isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public String getIsolationLevel() {
        return isolationLevel;
    }
}
