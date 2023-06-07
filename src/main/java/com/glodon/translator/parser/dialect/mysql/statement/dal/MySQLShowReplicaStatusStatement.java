package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowReplicaStatusStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
