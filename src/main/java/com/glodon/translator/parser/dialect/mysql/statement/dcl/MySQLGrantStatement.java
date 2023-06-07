
package com.glodon.translator.parser.dialect.mysql.statement.dcl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.MySQLRoleOrPrivilegeSegment;
import com.glodon.translator.parser.dialect.mysql.statement.segment.UserSegment;
import com.glodon.translator.parser.segment.generic.ACLTypeEnum;
import com.glodon.translator.parser.segment.generic.GrantLevelSegment;
import com.glodon.translator.parser.statement.dcl.GrantStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLGrantStatement extends GrantStatement implements MySQLStatement {

    private final Collection<MySQLRoleOrPrivilegeSegment> roleOrPrivileges = new LinkedList<>();

    private boolean allPrivileges;

    private final Collection<UserSegment> users = new LinkedList<>();

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

    public Collection<UserSegment> getUsers() {
        return users;
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
