package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dml.DeleteStatement;
import com.glodon.translator.parser.statement.dml.InsertStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;
import com.glodon.translator.parser.statement.dml.UpdateStatement;

import java.util.Optional;

public abstract class PrepareStatement extends AbstractSQLStatement implements DDLStatement {

    private SelectStatement select;

    private InsertStatement insert;

    private UpdateStatement update;

    private DeleteStatement delete;

    public Optional<SelectStatement> getSelect() {
        return Optional.ofNullable(select);
    }

    public Optional<InsertStatement> getInsert() {
        return Optional.ofNullable(insert);
    }

    public Optional<UpdateStatement> getUpdate() {
        return Optional.ofNullable(update);
    }

    public Optional<DeleteStatement> getDelete() {
        return Optional.ofNullable(delete);
    }

    public void setSelect(SelectStatement select) {
        this.select = select;
    }

    public void setInsert(InsertStatement insert) {
        this.insert = insert;
    }

    public void setUpdate(UpdateStatement update) {
        this.update = update;
    }

    public void setDelete(DeleteStatement delete) {
        this.delete = delete;
    }
}
