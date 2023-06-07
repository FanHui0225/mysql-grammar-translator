package com.glodon.translator.parser.value;

import com.glodon.translator.parser.ASTNode;

public interface ValueASTNode<T> extends ASTNode {

    T getValue();
}
