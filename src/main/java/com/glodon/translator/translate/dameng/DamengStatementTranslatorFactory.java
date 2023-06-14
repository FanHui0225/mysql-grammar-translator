package com.glodon.translator.translate.dameng;

import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLStatementTranslatorFactory;
import com.glodon.translator.translate.SQLTranslatorException;
import com.glodon.translator.translate.dameng.ddl.CreateTableStatementTranslator;

public final class DamengStatementTranslatorFactory implements SQLStatementTranslatorFactory {

    @Override
    public SQLStatementTranslator<SQLStatement> create(SQLStatement statement) {
        if (statement instanceof CreateTableStatement) {
            return new CreateTableStatementTranslator()._this();
        }
        throw new SQLTranslatorException("[" + statement.getClass() + "] statement translate not supported.");
    }
}
