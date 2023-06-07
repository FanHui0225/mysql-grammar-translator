package com.glodon.translator.parser.segment;

import com.glodon.translator.parser.ASTNode;

public interface SQLSegment extends ASTNode {

    int getStartIndex();

    int getStopIndex();
}
