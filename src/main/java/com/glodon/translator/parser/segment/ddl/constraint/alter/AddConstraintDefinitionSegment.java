package com.glodon.translator.parser.segment.ddl.constraint.alter;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.ConstraintDefinitionSegment;

public final class AddConstraintDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final ConstraintDefinitionSegment constraintDefinition;

    public AddConstraintDefinitionSegment(int startIndex, int stopIndex, ConstraintDefinitionSegment constraintDefinition) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.constraintDefinition = constraintDefinition;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public ConstraintDefinitionSegment getConstraintDefinition() {
        return constraintDefinition;
    }
}
