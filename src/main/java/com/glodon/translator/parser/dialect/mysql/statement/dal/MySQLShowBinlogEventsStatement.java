package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowBinlogEventsStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String logName;

    private LimitSegment limit;

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public LimitSegment getLimit() {
        return limit;
    }

    public void setLimit(LimitSegment limit) {
        this.limit = limit;
    }
}
