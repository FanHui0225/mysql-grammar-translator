package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class MySQLRoleOrPrivilegeSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String role;

    private final String host;

    private final MySQLPrivilegeSegment privilege;

    public MySQLRoleOrPrivilegeSegment(int startIndex, int stopIndex, String role, String host, MySQLPrivilegeSegment privilege) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.role = role;
        this.host = host;
        this.privilege = privilege;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getRole() {
        return role;
    }

    public String getHost() {
        return host;
    }

    public MySQLPrivilegeSegment getPrivilege() {
        return privilege;
    }
}
