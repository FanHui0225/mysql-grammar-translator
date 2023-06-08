
package com.glodon.translator.translate.rewrite;

public abstract class SQLToken implements Comparable<SQLToken> {

    private final int startIndex;

    public SQLToken(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public final int compareTo(final SQLToken sqlToken) {
        return startIndex - sqlToken.startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
