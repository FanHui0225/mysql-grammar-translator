package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.segment.ddl.index.IndexTypeSegment;
import com.glodon.translator.parser.statement.ddl.CommentStatement;

import java.util.Optional;

public final class CommentStatementHandler implements SQLStatementHandler {

    private CommentStatementHandler() {
    }

    public static Optional<IndexTypeSegment> getIndexType(final CommentStatement commentStatement) {
        return Optional.empty();
    }
}
