package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowRelayLogEventsStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String logName;

    private LimitSegment limit;

    private String channel;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
