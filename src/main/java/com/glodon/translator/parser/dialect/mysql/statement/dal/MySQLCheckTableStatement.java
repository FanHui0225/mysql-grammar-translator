package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLCheckTableStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private final Collection<SimpleTableSegment> tables = new LinkedList<>();

    public Collection<SimpleTableSegment> getTables() {
        return tables;
    }
}
