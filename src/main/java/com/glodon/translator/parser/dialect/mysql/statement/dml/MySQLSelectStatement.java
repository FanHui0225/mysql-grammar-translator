
package com.glodon.translator.parser.dialect.mysql.statement.dml;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.segment.dml.predicate.LockSegment;
import com.glodon.translator.parser.segment.generic.WindowSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.dml.SelectStatement;

import java.util.Optional;

public final class MySQLSelectStatement extends SelectStatement implements MySQLStatement {

    private SimpleTableSegment table;

    private LimitSegment limit;

    private LockSegment lock;

    private WindowSegment window;

    public Optional<LimitSegment> getLimit() {
        return Optional.ofNullable(limit);
    }

    public Optional<LockSegment> getLock() {
        return Optional.ofNullable(lock);
    }

    public Optional<WindowSegment> getWindow() {
        return Optional.ofNullable(window);
    }

    public Optional<SimpleTableSegment> getTable() {
        return Optional.ofNullable(table);
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public void setLimit(LimitSegment limit) {
        this.limit = limit;
    }

    public void setLock(LockSegment lock) {
        this.lock = lock;
    }

    public void setWindow(WindowSegment window) {
        this.window = window;
    }
}
