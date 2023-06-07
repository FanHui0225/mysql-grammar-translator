package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateFunctionStatement;
import com.glodon.translator.parser.segment.ddl.routine.RoutineBodySegment;
import com.glodon.translator.parser.statement.ddl.CreateFunctionStatement;

import java.util.Optional;

public final class CreateFunctionStatementHandler implements SQLStatementHandler {

    private CreateFunctionStatementHandler() {
    }

    public static Optional<RoutineBodySegment> getRoutineBodySegment(final CreateFunctionStatement createFunctionStatement) {
        if (createFunctionStatement instanceof MySQLStatement) {
            return ((MySQLCreateFunctionStatement) createFunctionStatement).getRoutineBody();
        }
        return Optional.empty();
    }
}
