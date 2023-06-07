package com.glodon.translator.parser.dialect.mysql.statement.dcl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.PasswordOrLockOptionSegment;
import com.glodon.translator.parser.dialect.mysql.statement.segment.TLSOptionSegment;
import com.glodon.translator.parser.dialect.mysql.statement.segment.UserResourceSegment;
import com.glodon.translator.parser.statement.dcl.CreateUserStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLCreateUserStatement extends CreateUserStatement implements MySQLStatement {

    private final Collection<String> defaultRoles = new LinkedList<>();

    private TLSOptionSegment tlsOptionSegment;

    private UserResourceSegment userResource;

    private PasswordOrLockOptionSegment passwordOrLockOption;

    public Collection<String> getDefaultRoles() {
        return defaultRoles;
    }

    public TLSOptionSegment getTlsOptionSegment() {
        return tlsOptionSegment;
    }

    public void setTlsOptionSegment(TLSOptionSegment tlsOptionSegment) {
        this.tlsOptionSegment = tlsOptionSegment;
    }

    public UserResourceSegment getUserResource() {
        return userResource;
    }

    public void setUserResource(UserResourceSegment userResource) {
        this.userResource = userResource;
    }

    public PasswordOrLockOptionSegment getPasswordOrLockOption() {
        return passwordOrLockOption;
    }

    public void setPasswordOrLockOption(PasswordOrLockOptionSegment passwordOrLockOption) {
        this.passwordOrLockOption = passwordOrLockOption;
    }
}
