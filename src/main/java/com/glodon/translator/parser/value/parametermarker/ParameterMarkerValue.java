package com.glodon.translator.parser.value.parametermarker;

import com.glodon.translator.parser.enums.ParameterMarkerType;
import com.glodon.translator.parser.value.ValueASTNode;

public final class ParameterMarkerValue implements ValueASTNode<Integer> {

    private final Integer value;

    private final ParameterMarkerType type;

    public ParameterMarkerValue(Integer value, ParameterMarkerType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public ParameterMarkerType getType() {
        return type;
    }
}
