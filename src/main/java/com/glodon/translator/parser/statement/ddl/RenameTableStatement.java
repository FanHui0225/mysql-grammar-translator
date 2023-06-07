package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.table.RenameTableDefinitionSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;

public abstract class RenameTableStatement extends AbstractSQLStatement implements DDLStatement {

    private final Collection<RenameTableDefinitionSegment> renameTables = new LinkedList<>();

    public Collection<RenameTableDefinitionSegment> getRenameTables() {
        return renameTables;
    }
}
