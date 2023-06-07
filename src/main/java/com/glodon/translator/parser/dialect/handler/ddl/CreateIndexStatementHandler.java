package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateIndexStatement;
import com.glodon.translator.parser.segment.ddl.table.AlgorithmTypeSegment;
import com.glodon.translator.parser.segment.ddl.table.LockTableSegment;
import com.glodon.translator.parser.statement.ddl.CreateIndexStatement;

import java.util.Optional;

public final class CreateIndexStatementHandler implements SQLStatementHandler {

    private CreateIndexStatementHandler() {
    }

    public static Optional<Integer> getGeneratedIndexStartIndex(final CreateIndexStatement createIndexStatement) {
        return Optional.empty();
    }

    public static boolean ifNotExists(final CreateIndexStatement createIndexStatement) {
        return false;
    }

    public static Optional<AlgorithmTypeSegment> getAlgorithmTypeSegment(final CreateIndexStatement createIndexStatement) {
        if (createIndexStatement instanceof MySQLCreateIndexStatement) {
            return ((MySQLCreateIndexStatement) createIndexStatement).getGetAlgorithmSegment();
        }
        return Optional.empty();
    }

    public static Optional<LockTableSegment> getLockTableSegment(final CreateIndexStatement createIndexStatement) {
        if (createIndexStatement instanceof MySQLCreateIndexStatement) {
            return ((MySQLCreateIndexStatement) createIndexStatement).getLockTableSegment();
        }
        return Optional.empty();
    }
}
