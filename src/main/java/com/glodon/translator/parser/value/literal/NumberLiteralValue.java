package com.glodon.translator.parser.value.literal;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberLiteralValue implements LiteralValue<Number> {

    private final Number value;

    public NumberLiteralValue(final String value) {
        this.value = getNumber(value);
    }

    private Number getNumber(final String value) {
        try {
            return getBigInteger(value);
        } catch (final NumberFormatException ex) {
            // TODO make sure with double and float
            return new BigDecimal(value);
        }
    }

    private static Number getBigInteger(final String value) {
        BigInteger result = new BigInteger(value);
        if (result.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) >= 0 && result.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) <= 0) {
            return result.intValue();
        }
        if (result.compareTo(new BigInteger(String.valueOf(Long.MIN_VALUE))) >= 0 && result.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) <= 0) {
            return result.longValue();
        }
        return result;
    }

    @Override
    public Number getValue() {
        return value;
    }
}
