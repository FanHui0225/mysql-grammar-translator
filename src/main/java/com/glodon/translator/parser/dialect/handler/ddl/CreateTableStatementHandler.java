package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateTableStatement;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class CreateTableStatementHandler implements SQLStatementHandler {

    private CreateTableStatementHandler() {
    }

    public static boolean ifNotExists(final CreateTableStatement createTableStatement) {
        if (createTableStatement instanceof MySQLStatement) {
            return ((MySQLCreateTableStatement) createTableStatement).isIfNotExists();
        }
        return false;
    }

    public static Optional<SelectStatement> getSelectStatement(final CreateTableStatement createTableStatement) {
        return Optional.empty();
    }

    public static List<ColumnSegment> getColumns(final CreateTableStatement createTableStatement) {
        return Collections.emptyList();
    }

    public static Optional<SimpleTableSegment> getLikeTable(final CreateTableStatement createTableStatement) {
        if (createTableStatement instanceof MySQLCreateTableStatement) {
            return ((MySQLCreateTableStatement) createTableStatement).getLikeTable();
        }
        return Optional.empty();
    }
}
