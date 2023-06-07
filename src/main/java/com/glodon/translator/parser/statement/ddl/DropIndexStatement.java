package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class DropIndexStatement extends AbstractSQLStatement implements DDLStatement {

    private final Collection<IndexSegment> indexes = new LinkedList<>();

    public Collection<IndexSegment> getIndexes() {
        return indexes;
    }
}
