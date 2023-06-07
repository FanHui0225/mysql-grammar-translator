package com.glodon.translator.parser;

import org.antlr.v4.runtime.tree.ParseTree;

public class SQLASTVisitorException extends RuntimeException {

    public SQLASTVisitorException(final Class<? extends ParseTree> parseTreeClass) {
        super(String.format("Can not accept SQL type `%s`.", parseTreeClass.getSimpleName()));
    }
}
