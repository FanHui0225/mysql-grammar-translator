package com.glodon.translator.translate.props;

public interface TypedPropertyKey {

    String getKey();

    String getDefaultValue();

    Class<?> getType();
}
