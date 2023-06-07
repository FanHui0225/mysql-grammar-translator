package com.glodon.translator.parser.value.props;

import com.glodon.translator.parser.value.ValueASTNode;

import java.util.Properties;

public final class PropertiesValue implements ValueASTNode<Properties> {

    private final Properties value = new Properties();

    @Override
    public Properties getValue() {
        return value;
    }
}
