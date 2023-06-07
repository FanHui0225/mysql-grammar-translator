package com.glodon.translator.parser.segment.ddl.constraint.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.ConstraintSegment;

public final class ModifyConstraintDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ConstraintSegment constraintName;

    public ModifyConstraintDefinitionSegment(int startIndex, int stopIndex, ConstraintSegment constraintName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.constraintName = constraintName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public ConstraintSegment getConstraintName() {
        return constraintName;
    }
}
