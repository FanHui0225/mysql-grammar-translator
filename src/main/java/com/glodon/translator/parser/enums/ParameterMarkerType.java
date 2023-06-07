package com.glodon.translator.parser.enums;


public enum ParameterMarkerType {

    QUESTION("?"), DOLLAR("$");

    private final String marker;

    ParameterMarkerType(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }
}
