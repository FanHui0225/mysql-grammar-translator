package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLAlterViewStatement;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.AlterViewStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

import java.util.Optional;

public final class AlterViewStatementHandler implements SQLStatementHandler {

    private AlterViewStatementHandler() {
    }

    public static Optional<SelectStatement> getSelectStatement(final AlterViewStatement alterViewStatement) {
        if (alterViewStatement instanceof MySQLStatement) {
            return Optional.of(((MySQLAlterViewStatement) alterViewStatement).getSelect());
        }
        return Optional.empty();
    }

    public static Optional<String> getViewDefinition(final AlterViewStatement alterViewStatement) {
        if (alterViewStatement instanceof MySQLStatement) {
            return Optional.of(((MySQLAlterViewStatement) alterViewStatement).getViewDefinition());
        }
        return Optional.empty();
    }

    public static Optional<SimpleTableSegment> getRenameView(final AlterViewStatement alterViewStatement) {
        return Optional.empty();
    }
}
