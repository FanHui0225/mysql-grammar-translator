
package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

public final class MySQLShowCreateTableStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private SimpleTableSegment table;

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }
}
