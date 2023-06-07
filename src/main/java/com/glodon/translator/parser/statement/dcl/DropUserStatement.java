package com.glodon.translator.parser.statement.dcl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class DropUserStatement extends AbstractSQLStatement implements DCLStatement {

    private final Collection<String> users = new LinkedList<>();

    public Collection<String> getUsers() {
        return users;
    }
}
