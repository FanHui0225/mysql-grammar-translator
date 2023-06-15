package com.glodon.translator.translate.props;

public final class TypedPropertyValue {

    private final Object value;

    public TypedPropertyValue(final TypedPropertyKey key, final String value) throws TypedPropertyValueException {
        this.value = createTypedValue(key, value);
    }

    private Object createTypedValue(final TypedPropertyKey key, final String value) throws TypedPropertyValueException {
        if (boolean.class == key.getType() || Boolean.class == key.getType()) {
            return Boolean.valueOf(value);
        }
        if (int.class == key.getType() || Integer.class == key.getType()) {
            try {
                return Integer.valueOf(value);
            } catch (final NumberFormatException ignored) {
                throw new TypedPropertyValueException(key, value);
            }
        }
        if (long.class == key.getType() || Long.class == key.getType()) {
            try {
                return Long.valueOf(value);
            } catch (final NumberFormatException ignored) {
                throw new TypedPropertyValueException(key, value);
            }
        }
        if (Enum.class.isAssignableFrom(key.getType())) {
            return getEnumValue(key, value);
        }
        return value;
    }

    private Enum<?> getEnumValue(final TypedPropertyKey key, final String value) throws TypedPropertyValueException {
        try {
            return (Enum<?>) key.getType().getMethod("valueOf", String.class).invoke(null, value.toUpperCase());
        } catch (final ReflectiveOperationException | IllegalArgumentException ignored) {
            throw new TypedPropertyValueException(key, value);
        }
    }

    public Object getValue() {
        return value;
    }
}
