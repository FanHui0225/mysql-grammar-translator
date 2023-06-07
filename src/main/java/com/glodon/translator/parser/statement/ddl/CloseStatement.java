package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.cursor.CursorNameSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class CloseStatement extends AbstractSQLStatement implements DDLStatement {

    private CursorNameSegment cursorName;

    private boolean closeAll;

    public Optional<CursorNameSegment> getCursorName() {
        return Optional.ofNullable(cursorName);
    }

    public void setCursorName(CursorNameSegment cursorName) {
        this.cursorName = cursorName;
    }

    public boolean isCloseAll() {
        return closeAll;
    }

    public void setCloseAll(boolean closeAll) {
        this.closeAll = closeAll;
    }
}
