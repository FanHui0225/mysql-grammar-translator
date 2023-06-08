package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateTableStatement;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.translate.SQLTranslator;

public class DamengCreateTableTranslator implements SQLTranslator {

    @Override
    public String translate(SQLStatement statement) {
        MySQLCreateTableStatement mySQLCreateTableStatement = (MySQLCreateTableStatement) statement;


        return null;
    }
}
