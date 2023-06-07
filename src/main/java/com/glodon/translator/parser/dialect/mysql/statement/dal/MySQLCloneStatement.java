package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.CloneActionSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLCloneStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private CloneActionSegment cloneActionSegment;

    public CloneActionSegment getCloneActionSegment() {
        return cloneActionSegment;
    }

    public void setCloneActionSegment(CloneActionSegment cloneActionSegment) {
        this.cloneActionSegment = cloneActionSegment;
    }
}
