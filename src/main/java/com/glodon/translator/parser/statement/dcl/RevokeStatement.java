package com.glodon.translator.parser.statement.dcl;


import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class RevokeStatement extends AbstractSQLStatement implements DCLStatement {

    private final Collection<SimpleTableSegment> tables = new LinkedList<>();

    public Collection<SimpleTableSegment> getTables() {
        return tables;
    }
}
