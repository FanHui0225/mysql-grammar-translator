package com.glodon.translator.translate;

import com.glodon.translator.parser.ASTNode;

public abstract class SQLTranslator<E extends ASTNode> {

    private final StringBuilder SQL = new StringBuilder();

    public abstract String translate(E statement);

    public SQLTranslator<E> append(final char value) {
        SQL.append(value);
        return this;
    }

    public SQLTranslator<E> append(String phrase) {
        SQL.append(phrase);
        return this;
    }

    public SQLTranslator<E> appendIndent() {
        append('\t');
        return this;
    }

    public SQLTranslator<E> appendLineFeed() {
        append('\n');
        return this;
    }

    public SQLTranslator<E> appendBlankSpace() {
        append(' ');
        return this;
    }


    @Override
    public String toString() {
        return SQL.toString();
    }
}
