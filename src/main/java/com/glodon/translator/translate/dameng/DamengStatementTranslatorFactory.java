package com.glodon.translator.translate.dameng;

import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.CreateDatabaseStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.parser.statement.dml.InsertStatement;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLStatementTranslatorFactory;
import com.glodon.translator.translate.SQLTranslatorException;
import com.glodon.translator.translate.dameng.ddl.CreateDatabaseStatementTranslator;
import com.glodon.translator.translate.dameng.ddl.CreateTableStatementTranslator;
import com.glodon.translator.translate.dameng.dml.InsertStatementTranslator;

public final class DamengStatementTranslatorFactory implements SQLStatementTranslatorFactory {

    @Override
    public SQLStatementTranslator<SQLStatement> create(SQLStatement statement) {
        if (statement instanceof CreateTableStatement) {
            return new CreateTableStatementTranslator()._this();
        }
        if (statement instanceof CreateDatabaseStatement) {
            return new CreateDatabaseStatementTranslator()._this();
        }
        if (statement instanceof InsertStatement) {
            return new InsertStatementTranslator()._this();
        }
        throw new SQLTranslatorException("[" + statement.getClass() + "] statement translate not supported.");
    }
}
