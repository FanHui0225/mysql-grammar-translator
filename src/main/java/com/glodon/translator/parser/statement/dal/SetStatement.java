package com.glodon.translator.parser.statement.dal;

import com.glodon.translator.parser.segment.dal.VariableAssignSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.LinkedList;
import java.util.List;

public abstract class SetStatement extends AbstractSQLStatement implements DALStatement {

    private final List<VariableAssignSegment> variableAssigns = new LinkedList<>();

    public List<VariableAssignSegment> getVariableAssigns() {
        return variableAssigns;
    }
}
