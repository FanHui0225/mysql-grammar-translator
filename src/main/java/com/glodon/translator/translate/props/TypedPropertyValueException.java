package com.glodon.translator.translate.props;

public final class TypedPropertyValueException extends Exception {

    public TypedPropertyValueException(final TypedPropertyKey key, final String value) {
        this("Value `%s` of `%s` cannot convert to type `%s`", value, key.getKey(), key.getType().getName());
    }

    protected TypedPropertyValueException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    protected TypedPropertyValueException(final Exception cause) {
        super(cause);
    }

    protected TypedPropertyValueException(final String message, final Exception cause) {
        super(message, cause);
    }
}
