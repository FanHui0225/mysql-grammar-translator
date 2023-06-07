package com.glodon.translator.parser.dialect.mysql.statement.tcl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.tcl.LockStatement;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLLockStatement extends LockStatement implements MySQLStatement {

    private final Collection<SimpleTableSegment> tables = new LinkedList<>();

    public Collection<SimpleTableSegment> getTables() {
        return tables;
    }
}
