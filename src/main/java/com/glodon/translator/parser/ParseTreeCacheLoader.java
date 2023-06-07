package com.glodon.translator.parser;

import com.github.benmanes.caffeine.cache.CacheLoader;

import javax.annotation.ParametersAreNonnullByDefault;

public final class ParseTreeCacheLoader implements CacheLoader<String, ParseASTNode> {

    private final SQLParserExecutor sqlParserExecutor;

    public ParseTreeCacheLoader(SQLParserExecutor sqlParserExecutor) {
        this.sqlParserExecutor = sqlParserExecutor;
    }

    @ParametersAreNonnullByDefault
    @Override
    public ParseASTNode load(final String sql) {
        return sqlParserExecutor.parseASTNode(sql);
    }
}