package com.glodon.translator.parser;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public final class ParseTreeCacheBuilder {

    public static final class CacheOption {

        private final int initialCapacity;

        private final long maximumSize;

        public CacheOption(int initialCapacity, long maximumSize) {
            this.initialCapacity = initialCapacity;
            this.maximumSize = maximumSize;
        }

        public int getInitialCapacity() {
            return initialCapacity;
        }

        public long getMaximumSize() {
            return maximumSize;
        }

        @Override
        public String toString() {
            return String.format("initialCapacity: %d, maximumSize: %d", initialCapacity, maximumSize);
        }
    }

    private ParseTreeCacheBuilder() {
    }

    public static LoadingCache<String, ParseASTNode> build(final CacheOption option, final SQLParserExecutor sqlParserExecutor) {
        return Caffeine.newBuilder().softValues().initialCapacity(option.getInitialCapacity()).maximumSize(option.getMaximumSize())
                .build(new ParseTreeCacheLoader(sqlParserExecutor));
    }
}
