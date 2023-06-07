package com.glodon.translator.parser.dialect.mysql.statement.dcl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.MySQLRoleOrPrivilegeSegment;
import com.glodon.translator.parser.dialect.mysql.statement.segment.UserSegment;
import com.glodon.translator.parser.segment.generic.ACLTypeEnum;
import com.glodon.translator.parser.segment.generic.GrantLevelSegment;
import com.glodon.translator.parser.statement.dcl.RevokeStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLRevokeStatement extends RevokeStatement implements MySQLStatement {

    private final Collection<MySQLRoleOrPrivilegeSegment> roleOrPrivileges = new LinkedList<>();

    private boolean allPrivileges;

    private UserSegment onUser;

    private final Collection<UserSegment> fromUsers = new LinkedList<>();

    private ACLTypeEnum aclType;

    private GrantLevelSegment level;

    public Collection<MySQLRoleOrPrivilegeSegment> getRoleOrPrivileges() {
        return roleOrPrivileges;
    }

    public boolean isAllPrivileges() {
        return allPrivileges;
    }

    public void setAllPrivileges(boolean allPrivileges) {
        this.allPrivileges = allPrivileges;
    }

    public UserSegment getOnUser() {
        return onUser;
    }

    public void setOnUser(UserSegment onUser) {
        this.onUser = onUser;
    }

    public Collection<UserSegment> getFromUsers() {
        return fromUsers;
    }

    public ACLTypeEnum getAclType() {
        return aclType;
    }

    public void setAclType(ACLTypeEnum aclType) {
        this.aclType = aclType;
    }

    public GrantLevelSegment getLevel() {
        return level;
    }

    public void setLevel(GrantLevelSegment level) {
        this.level = level;
    }
}
