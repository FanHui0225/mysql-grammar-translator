package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.cursor.CursorNameSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public abstract class DeclareStatement extends AbstractSQLStatement implements DDLStatement {

    private CursorNameSegment cursorName;

    private SelectStatement select;

    public CursorNameSegment getCursorName() {
        return cursorName;
    }

    public void setCursorName(CursorNameSegment cursorName) {
        this.cursorName = cursorName;
    }

    public SelectStatement getSelect() {
        return select;
    }

    public void setSelect(SelectStatement select) {
        this.select = select;
    }
}
