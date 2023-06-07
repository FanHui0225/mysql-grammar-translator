package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class DropViewStatement extends AbstractSQLStatement implements DDLStatement {

    private final Collection<SimpleTableSegment> views = new LinkedList<>();

    public Collection<SimpleTableSegment> getViews() {
        return views;
    }
}
