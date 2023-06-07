package com.glodon.translator.parser.dialect.mysql.statement.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.ddl.table.AlgorithmTypeSegment;
import com.glodon.translator.parser.segment.ddl.table.LockTableSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.DropIndexStatement;

import java.util.Optional;

public final class MySQLDropIndexStatement extends DropIndexStatement implements MySQLStatement {

    private SimpleTableSegment table;

    private AlgorithmTypeSegment algorithmSegment;

    private LockTableSegment lockTableSegment;

    public Optional<SimpleTableSegment> getTable() {
        return Optional.ofNullable(table);
    }

    public Optional<AlgorithmTypeSegment> getGetAlgorithmSegment() {
        return Optional.ofNullable(algorithmSegment);
    }

    public Optional<LockTableSegment> getLockTableSegment() {
        return Optional.ofNullable(lockTableSegment);
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public AlgorithmTypeSegment getAlgorithmSegment() {
        return algorithmSegment;
    }

    public void setAlgorithmSegment(AlgorithmTypeSegment algorithmSegment) {
        this.algorithmSegment = algorithmSegment;
    }

    public void setLockTableSegment(LockTableSegment lockTableSegment) {
        this.lockTableSegment = lockTableSegment;
    }
}
