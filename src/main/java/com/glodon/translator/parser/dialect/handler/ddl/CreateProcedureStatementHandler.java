package com.glodon.translator.parser.dialect.handler.ddl;

import com.glodon.translator.parser.dialect.handler.SQLStatementHandler;
import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateProcedureStatement;
import com.glodon.translator.parser.segment.ddl.routine.RoutineBodySegment;
import com.glodon.translator.parser.statement.ddl.CreateProcedureStatement;

import java.util.Optional;

public final class CreateProcedureStatementHandler implements SQLStatementHandler {

    private CreateProcedureStatementHandler() {
    }

    public static Optional<RoutineBodySegment> getRoutineBodySegment(final CreateProcedureStatement createProcedureStatement) {
        if (createProcedureStatement instanceof MySQLStatement) {
            return ((MySQLCreateProcedureStatement) createProcedureStatement).getRoutineBody();
        }
        return Optional.empty();
    }
}
