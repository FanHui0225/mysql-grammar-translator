package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.LinkedList;
import java.util.List;

public final class MySQLInstallComponentStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {
    
    private final List<String> components = new LinkedList<>();

    public List<String> getComponents() {
        return components;
    }
}
