package com.glodon.translator.parser.dialect.mysql.statement.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;

import java.util.Optional;

public final class MySQLCreateTableStatement extends CreateTableStatement implements MySQLStatement {

    private final boolean ifNotExists;

    private SimpleTableSegment likeTable;

    public MySQLCreateTableStatement(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public Optional<SimpleTableSegment> getLikeTable() {
        return Optional.ofNullable(likeTable);
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setLikeTable(SimpleTableSegment likeTable) {
        this.likeTable = likeTable;
    }
}
