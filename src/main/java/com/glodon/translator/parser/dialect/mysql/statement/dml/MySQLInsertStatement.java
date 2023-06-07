package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.column.OnDuplicateKeyColumnsSegment;
import com.glodon.translator.parser.statement.dml.InsertStatement;

import java.util.Optional;

public final class MySQLInsertStatement extends InsertStatement implements MySQLStatement {

    private SetAssignmentSegment setAssignment;

    private OnDuplicateKeyColumnsSegment onDuplicateKeyColumns;

    public Optional<SetAssignmentSegment> getSetAssignment() {
        return Optional.ofNullable(setAssignment);
    }

    public Optional<OnDuplicateKeyColumnsSegment> getOnDuplicateKeyColumns() {
        return Optional.ofNullable(onDuplicateKeyColumns);
    }

    public void setSetAssignment(SetAssignmentSegment setAssignment) {
        this.setAssignment = setAssignment;
    }

    public void setOnDuplicateKeyColumns(OnDuplicateKeyColumnsSegment onDuplicateKeyColumns) {
        this.onDuplicateKeyColumns = onDuplicateKeyColumns;
    }
}
