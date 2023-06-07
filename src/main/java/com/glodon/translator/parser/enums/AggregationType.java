
package com.glodon.translator.parser.enums;

import java.util.Arrays;

public enum AggregationType {

    MAX, MIN, SUM, COUNT, AVG, BIT_XOR;

    public static boolean isAggregationType(final String aggregationType) {
        return Arrays.stream(values()).anyMatch(each -> aggregationType.equalsIgnoreCase(each.name()));
    }
}
