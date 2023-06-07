package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.ClusterStatement;

import java.util.Optional;

public final class ClusterStatementHandler implements SQLStatementHandler {

    private ClusterStatementHandler() {
    }

    public static Optional<SimpleTableSegment> getSimpleTableSegment(final ClusterStatement clusterStatement) {
        return Optional.empty();
    }

    public static Optional<IndexSegment> getIndexSegment(final ClusterStatement clusterStatement) {
        return Optional.empty();
    }
}
