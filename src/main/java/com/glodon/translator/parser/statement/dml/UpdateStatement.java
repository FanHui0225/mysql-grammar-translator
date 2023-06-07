package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.predicate.WhereSegment;
import com.glodon.translator.parser.segment.generic.table.TableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class UpdateStatement extends AbstractSQLStatement implements DMLStatement {

    private TableSegment table;

    private SetAssignmentSegment setAssignment;

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

    public SetAssignmentSegment getSetAssignment() {
        return setAssignment;
    }

    public void setSetAssignment(SetAssignmentSegment setAssignment) {
        this.setAssignment = setAssignment;
    }

    public void setWhere(WhereSegment where) {
        this.where = where;
    }
}
