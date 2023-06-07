package com.glodon.translator.parser.segment.ddl.table;

import com.glodon.translator.parser.enums.LockTableOption;
import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;

public final class LockTableSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final LockTableOption lockTableOption;

    public LockTableSegment(int startIndex, int stopIndex, LockTableOption lockTableOption) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.lockTableOption = lockTableOption;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public LockTableOption getLockTableOption() {
        return lockTableOption;
    }
}
