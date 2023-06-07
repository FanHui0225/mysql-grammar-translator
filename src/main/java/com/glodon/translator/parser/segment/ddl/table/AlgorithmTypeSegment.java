package com.glodon.translator.parser.segment.ddl.table;

import com.glodon.translator.parser.enums.AlgorithmOption;
import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;

public final class AlgorithmTypeSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final AlgorithmOption algorithmOption;

    public AlgorithmTypeSegment(int startIndex, int stopIndex, AlgorithmOption algorithmOption) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.algorithmOption = algorithmOption;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public AlgorithmOption getAlgorithmOption() {
        return algorithmOption;
    }
}
