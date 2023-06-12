package com.glodon.translator.translate.dameng;

import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateTableStatement;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.ddl.CreateTableStatement;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.dameng.ddl.CreateTableStatementTranslator;

public class MySQLToDamengStatementTranslator extends SQLStatementTranslator<SQLStatement> {

    @Override
    public String translate(SQLStatement statement) {
        if (statement instanceof CreateTableStatement) {
            return new CreateTableStatementTranslator().translate((MySQLCreateTableStatement) statement);
        }
        return null;
    }
}
