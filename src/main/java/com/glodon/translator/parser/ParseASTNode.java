
package com.glodon.translator.parser;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collection;
import java.util.LinkedList;

public final class ParseASTNode implements ASTNode {

    private final ParseTree parseTree;

    private final CommonTokenStream tokenStream;

    public ParseASTNode(ParseTree parseTree, CommonTokenStream tokenStream) {
        this.parseTree = parseTree;
        this.tokenStream = tokenStream;
    }

    public ParseTree getRootNode() {
        return parseTree.getChild(0);
    }

    public Collection<Token> getHiddenTokens() {
        Collection<Token> result = new LinkedList<>();
        for (Token each : tokenStream.getTokens()) {
            if (Token.HIDDEN_CHANNEL == each.getChannel()) {
                result.add(each);
            }
        }
        return result;
    }
}
