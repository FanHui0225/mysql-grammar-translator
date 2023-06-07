package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class AlterIndexStatement extends AbstractSQLStatement implements DDLStatement {

    private IndexSegment index;

    public Optional<IndexSegment> getIndex() {
        return Optional.ofNullable(index);
    }


    public void setIndex(IndexSegment index) {
        this.index = index;
    }
}
