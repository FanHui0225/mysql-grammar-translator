package com.glodon.translator.translate.dameng;

import com.glodon.translator.translate.props.ConfigurationPropertyKey;
import com.glodon.translator.translate.props.TypedProperties;

public final class DamengConfigurationProperties extends TypedProperties<ConfigurationPropertyKey> {

    private final static class ConfigurationPropertiesHolder {
        public static final DamengConfigurationProperties INSTANCE = new DamengConfigurationProperties();

        private ConfigurationPropertiesHolder() {
        }
    }

    private DamengConfigurationProperties() {
        super(ConfigurationPropertyKey.class, DamengConfigurationProperties.class.getClassLoader().getResource("dameng.conf").getPath());
    }

    public final static DamengConfigurationProperties INSTANCE() {
        return ConfigurationPropertiesHolder.INSTANCE;
    }
}
