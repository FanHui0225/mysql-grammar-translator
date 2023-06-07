package com.glodon.translator.parser.enums;


import java.util.Collection;
import java.util.EnumSet;

public enum DirectionType {

    NEXT("NEXT"),

    PRIOR("PRIOR"),

    FIRST("FIRST"),

    LAST("LAST"),

    ABSOLUTE_COUNT("ABSOLUTE"),

    RELATIVE_COUNT("RELATIVE"),

    COUNT(""),

    ALL("ALL"),

    FORWARD("FORWARD"),

    FORWARD_COUNT("FORWARD"),

    FORWARD_ALL("FORWARD ALL"),

    BACKWARD("BACKWARD"),

    BACKWARD_COUNT("BACKWARD"),

    BACKWARD_ALL("BACKWARD ALL");

    private static final Collection<DirectionType> ALL_DIRECTION_TYPES = EnumSet.of(ALL, FORWARD_ALL, BACKWARD_ALL);

    private static final Collection<DirectionType> FORWARD_COUNT_DIRECTION_TYPES = EnumSet.of(DirectionType.NEXT, DirectionType.COUNT, DirectionType.FORWARD, DirectionType.FORWARD_COUNT);

    private static final Collection<DirectionType> BACKWARD_COUNT_DIRECTION_TYPES = EnumSet.of(DirectionType.PRIOR, DirectionType.BACKWARD, DirectionType.BACKWARD_COUNT);

    private final String name;

    DirectionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isAllDirectionType(final DirectionType directionType) {
        return ALL_DIRECTION_TYPES.contains(directionType);
    }

    public static boolean isForwardCountDirectionType(final DirectionType directionType) {
        return FORWARD_COUNT_DIRECTION_TYPES.contains(directionType);
    }

    public static boolean isBackwardCountDirectionType(final DirectionType directionType) {
        return BACKWARD_COUNT_DIRECTION_TYPES.contains(directionType);
    }
}
