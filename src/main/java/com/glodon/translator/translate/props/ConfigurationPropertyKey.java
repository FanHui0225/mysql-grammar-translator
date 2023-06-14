package com.glodon.translator.translate.props;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public enum ConfigurationPropertyKey implements PropertyKey {
    ;

    private final String key;

    private final String defaultValue;

    ConfigurationPropertyKey(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    public static Collection<String> getKeyNames() {
        return Arrays.stream(values()).map(ConfigurationPropertyKey::name).collect(Collectors.toList());
    }
}
