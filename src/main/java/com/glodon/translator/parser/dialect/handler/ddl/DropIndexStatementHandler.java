package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLDropIndexStatement;
import com.glodon.translator.parser.segment.ddl.table.AlgorithmTypeSegment;
import com.glodon.translator.parser.segment.ddl.table.LockTableSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.DropIndexStatement;

import java.util.Optional;

public final class DropIndexStatementHandler implements SQLStatementHandler {

    private DropIndexStatementHandler() {
    }

    public static Optional<SimpleTableSegment> getSimpleTableSegment(final DropIndexStatement dropIndexStatement) {
        if (dropIndexStatement instanceof MySQLStatement) {
            return ((MySQLDropIndexStatement) dropIndexStatement).getTable();
        }
        return Optional.empty();
    }

    public static boolean ifExists(final DropIndexStatement dropIndexStatement) {
        return false;
    }

    public static Optional<AlgorithmTypeSegment> getAlgorithmTypeSegment(final DropIndexStatement dropIndexStatement) {
        if (dropIndexStatement instanceof MySQLDropIndexStatement) {
            return ((MySQLDropIndexStatement) dropIndexStatement).getGetAlgorithmSegment();
        }
        return Optional.empty();
    }

    public static Optional<LockTableSegment> getLockTableSegment(final DropIndexStatement dropIndexStatement) {
        if (dropIndexStatement instanceof MySQLDropIndexStatement) {
            return ((MySQLDropIndexStatement) dropIndexStatement).getLockTableSegment();
        }
        return Optional.empty();
    }
}
