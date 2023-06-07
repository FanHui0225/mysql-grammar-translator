package com.glodon.translator.parser.segment.ddl.routine;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.AlterTableStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.parser.statement.ddl.DropTableStatement;
import com.glodon.translator.parser.statement.ddl.TruncateStatement;
import com.glodon.translator.parser.statement.dml.DeleteStatement;
import com.glodon.translator.parser.statement.dml.InsertStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;
import com.glodon.translator.parser.statement.dml.UpdateStatement;

import java.util.Optional;

public class ValidStatementSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private SQLStatement sqlStatement;

    public ValidStatementSegment(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    public Optional<CreateTableStatement> getCreateTable() {
        return sqlStatement instanceof CreateTableStatement ? Optional.of((CreateTableStatement) sqlStatement) : Optional.empty();
    }

    public Optional<AlterTableStatement> getAlterTable() {
        return sqlStatement instanceof AlterTableStatement ? Optional.of((AlterTableStatement) sqlStatement) : Optional.empty();
    }

    public Optional<DropTableStatement> getDropTable() {
        return sqlStatement instanceof DropTableStatement ? Optional.of((DropTableStatement) sqlStatement) : Optional.empty();
    }

    public Optional<TruncateStatement> getTruncate() {
        return sqlStatement instanceof TruncateStatement ? Optional.of((TruncateStatement) sqlStatement) : Optional.empty();
    }

    public Optional<InsertStatement> getInsert() {
        return sqlStatement instanceof InsertStatement ? Optional.of((InsertStatement) sqlStatement) : Optional.empty();
    }

    public Optional<InsertStatement> getReplace() {
        return sqlStatement instanceof InsertStatement ? Optional.of((InsertStatement) sqlStatement) : Optional.empty();
    }

    public Optional<UpdateStatement> getUpdate() {
        return sqlStatement instanceof UpdateStatement ? Optional.of((UpdateStatement) sqlStatement) : Optional.empty();
    }

    public Optional<DeleteStatement> getDelete() {
        return sqlStatement instanceof DeleteStatement ? Optional.of((DeleteStatement) sqlStatement) : Optional.empty();
    }

    public Optional<SelectStatement> getSelect() {
        return sqlStatement instanceof SelectStatement ? Optional.of((SelectStatement) sqlStatement) : Optional.empty();
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public SQLStatement getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(SQLStatement sqlStatement) {
        this.sqlStatement = sqlStatement;
    }
}
