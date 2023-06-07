package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.LoadTableIndexSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLLoadIndexInfoStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private final Collection<LoadTableIndexSegment> tableIndexes = new LinkedList<>();

    public Collection<LoadTableIndexSegment> getTableIndexes() {
        return tableIndexes;
    }
}
