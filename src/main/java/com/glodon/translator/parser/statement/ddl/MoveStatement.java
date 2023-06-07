package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.cursor.CursorNameSegment;
import com.glodon.translator.parser.segment.ddl.cursor.DirectionSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Optional;

public abstract class MoveStatement extends AbstractSQLStatement implements DDLStatement {

    private CursorNameSegment cursorName;

    private DirectionSegment direction;

    public Optional<DirectionSegment> getDirection() {
        return Optional.ofNullable(direction);
    }

    public CursorNameSegment getCursorName() {
        return cursorName;
    }

    public void setCursorName(CursorNameSegment cursorName) {
        this.cursorName = cursorName;
    }

    public void setDirection(DirectionSegment direction) {
        this.direction = direction;
    }
}
