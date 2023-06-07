package com.glodon.translator.parser.dialect.mysql.statement.dal;


import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.segment.dal.ShowFilterSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;

import java.util.Optional;

public final class MySQLShowCollationStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {
    
    private ShowFilterSegment filter;
    
    public Optional<ShowFilterSegment> getFilter() {
        return Optional.ofNullable(filter);
    }

    public void setFilter(ShowFilterSegment filter) {
        this.filter = filter;
    }
}
