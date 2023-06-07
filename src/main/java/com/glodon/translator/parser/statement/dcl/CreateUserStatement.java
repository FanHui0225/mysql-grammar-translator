package com.glodon.translator.parser.statement.dcl;

import com.glodon.translator.parser.dialect.mysql.statement.segment.UserSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class CreateUserStatement extends AbstractSQLStatement implements DCLStatement {

    private final Collection<UserSegment> users = new LinkedList<>();

    public Collection<UserSegment> getUsers() {
        return users;
    }
}
