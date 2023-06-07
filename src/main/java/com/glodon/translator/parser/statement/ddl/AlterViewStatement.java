
package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class AlterViewStatement extends AbstractSQLStatement implements DDLStatement {

    private SimpleTableSegment view;

    public SimpleTableSegment getView() {
        return view;
    }

    public void setView(SimpleTableSegment view) {
        this.view = view;
    }
}
