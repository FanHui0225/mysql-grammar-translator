package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public abstract class CreateViewStatement extends AbstractSQLStatement implements DDLStatement {

    private SimpleTableSegment view;

    private String viewDefinition;

    private SelectStatement select;

    public SimpleTableSegment getView() {
        return view;
    }

    public void setView(SimpleTableSegment view) {
        this.view = view;
    }

    public String getViewDefinition() {
        return viewDefinition;
    }

    public void setViewDefinition(String viewDefinition) {
        this.viewDefinition = viewDefinition;
    }

    public SelectStatement getSelect() {
        return select;
    }

    public void setSelect(SelectStatement select) {
        this.select = select;
    }
}
