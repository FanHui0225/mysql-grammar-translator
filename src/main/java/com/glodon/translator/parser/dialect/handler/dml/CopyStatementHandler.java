
package com.glodon.translator.parser.dialect.handler.dml;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.prepare.PrepareStatementQuerySegment;
import com.glodon.translator.parser.statement.dml.CopyStatement;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public final class CopyStatementHandler implements SQLStatementHandler {

    private CopyStatementHandler() {
    }

    public static Optional<PrepareStatementQuerySegment> getPrepareStatementQuerySegment(final CopyStatement copyStatement) {
        return Optional.empty();
    }

    public static Collection<ColumnSegment> getColumns(final CopyStatement copyStatement) {
        return Collections.emptyList();
    }
}
