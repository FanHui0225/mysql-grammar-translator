package com.glodon.translator.parser.dialect.mysql.statement.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.statement.ddl.AlterViewStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public final class MySQLAlterViewStatement extends AlterViewStatement implements MySQLStatement {

    private SelectStatement select;

    private String viewDefinition;

    public SelectStatement getSelect() {
        return select;
    }

    public void setSelect(SelectStatement select) {
        this.select = select;
    }

    public String getViewDefinition() {
        return viewDefinition;
    }

    public void setViewDefinition(String viewDefinition) {
        this.viewDefinition = viewDefinition;
    }
}
