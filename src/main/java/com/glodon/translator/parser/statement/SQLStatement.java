package com.glodon.translator.parser.statement;

import com.glodon.translator.parser.ASTNode;

public interface SQLStatement extends ASTNode {

    int getParameterCount();
}
