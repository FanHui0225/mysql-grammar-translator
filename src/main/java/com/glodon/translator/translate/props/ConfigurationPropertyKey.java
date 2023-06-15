
package com.glodon.translator.translate.props;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum ConfigurationPropertyKey implements TypedPropertyKey {

    CREATE_TABLE_ADDITIONAL_PARAMETERS("create-table-additional-parameters", "", String.class, false),

    ;

    private final String key;

    private final String defaultValue;

    private final Class<?> type;

    private final boolean rebootRequired;

    ConfigurationPropertyKey(String key, String defaultValue, Class<?> type, boolean rebootRequired) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.type = type;
        this.rebootRequired = rebootRequired;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    public boolean isRebootRequired() {
        return rebootRequired;
    }

    public static Collection<String> getKeyNames() {
        return Arrays.stream(values()).map(ConfigurationPropertyKey::name).collect(Collectors.toList());
    }
}
