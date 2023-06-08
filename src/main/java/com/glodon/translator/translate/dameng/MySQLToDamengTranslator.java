package com.glodon.translator.translate.dameng;

import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.translate.SQLTranslator;
import com.glodon.translator.translate.dameng.ddl.DamengCreateTableTranslator;

public class MySQLToDamengTranslator implements SQLTranslator {

    @Override
    public String translate(SQLStatement statement) {
        if (statement instanceof CreateTableStatement) {
            return new DamengCreateTableTranslator().translate(statement);
        }
        return null;
    }
}
