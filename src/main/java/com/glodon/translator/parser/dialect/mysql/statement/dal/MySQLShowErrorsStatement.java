package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowErrorsStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private LimitSegment limit;

    public LimitSegment getLimit() {
        return limit;
    }

    public void setLimit(LimitSegment limit) {
        this.limit = limit;
    }
}
