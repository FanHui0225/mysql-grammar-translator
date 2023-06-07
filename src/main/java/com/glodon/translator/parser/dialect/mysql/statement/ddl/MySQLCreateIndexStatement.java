package com.glodon.translator.parser.dialect.mysql.statement.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.ddl.table.AlgorithmTypeSegment;
import com.glodon.translator.parser.segment.ddl.table.LockTableSegment;
import com.glodon.translator.parser.statement.ddl.CreateIndexStatement;

import java.util.Optional;

public final class MySQLCreateIndexStatement extends CreateIndexStatement implements MySQLStatement {

    private AlgorithmTypeSegment algorithmSegment;

    private LockTableSegment lockTableSegment;

    public Optional<AlgorithmTypeSegment> getGetAlgorithmSegment() {
        return Optional.ofNullable(algorithmSegment);
    }

    public Optional<LockTableSegment> getLockTableSegment() {
        return Optional.ofNullable(lockTableSegment);
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
