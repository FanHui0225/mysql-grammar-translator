package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.dml.predicate.WhereSegment;
import com.glodon.translator.parser.segment.generic.table.TableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class DeleteStatement extends AbstractSQLStatement implements DMLStatement {

    private TableSegment table;

    private WhereSegment where;

    public Optional<WhereSegment> getWhere() {
        return Optional.ofNullable(where);
    }

    public TableSegment getTable() {
        return table;
    }

    public void setTable(TableSegment table) {
        this.table = table;
    }

    public void setWhere(WhereSegment where) {
        this.where = where;
    }
}
