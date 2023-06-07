package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.AlterIndexStatement;

import java.util.Optional;

public final class AlterIndexStatementHandler implements SQLStatementHandler {

    private AlterIndexStatementHandler() {
    }

    public static Optional<SimpleTableSegment> getSimpleTableSegment(final AlterIndexStatement alterIndexStatement) {
        return Optional.empty();
    }

    public static Optional<IndexSegment> getRenameIndexSegment(final AlterIndexStatement alterIndexStatement) {
        return Optional.empty();
    }
}
