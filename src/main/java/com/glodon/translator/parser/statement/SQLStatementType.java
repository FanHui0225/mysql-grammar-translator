package com.glodon.translator.parser.statement;

import com.glodon.translator.parser.statement.ddl.DDLStatement;
import com.glodon.translator.parser.statement.dml.DMLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public enum SQLStatementType {

    DML, DDL, TCL, DCL, DAL, RL;

    private static final Collection<Class<? extends SQLStatement>> INVOLVE_DATA_CHANGES_STATEMENTS = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private static final Collection<Class<? extends SQLStatement>> NOT_INVOLVE_DATA_CHANGES_STATEMENTS = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public static boolean involvesDataChanges(final SQLStatement sqlStatement) {
        Class<? extends SQLStatement> sqlStatementClass = sqlStatement.getClass();
        if (NOT_INVOLVE_DATA_CHANGES_STATEMENTS.contains(sqlStatementClass)) {
            return false;
        }
        if (INVOLVE_DATA_CHANGES_STATEMENTS.contains(sqlStatementClass)) {
            return true;
        }
        if (sqlStatement instanceof SelectStatement) {
            NOT_INVOLVE_DATA_CHANGES_STATEMENTS.add(sqlStatementClass);
            return false;
        }
        if (sqlStatement instanceof DMLStatement || sqlStatement instanceof DDLStatement) {
            INVOLVE_DATA_CHANGES_STATEMENTS.add(sqlStatementClass);
            return true;
        }
        NOT_INVOLVE_DATA_CHANGES_STATEMENTS.add(sqlStatementClass);
        return false;
    }
}
