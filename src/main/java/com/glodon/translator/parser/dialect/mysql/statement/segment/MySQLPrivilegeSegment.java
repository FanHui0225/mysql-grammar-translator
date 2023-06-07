package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.generic.PrivilegeTypeEnum;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLPrivilegeSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final PrivilegeTypeEnum type;

    private final Collection<String> columns = new LinkedList<>();

    public MySQLPrivilegeSegment(int startIndex, int stopIndex, PrivilegeTypeEnum type) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.type = type;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public PrivilegeTypeEnum getType() {
        return type;
    }

    public Collection<String> getColumns() {
        return columns;
    }
}
