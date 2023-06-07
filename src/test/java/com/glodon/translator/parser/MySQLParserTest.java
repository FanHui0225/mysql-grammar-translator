package com.glodon.translator.parser;

import com.glodon.translator.parser.dialect.mysql.MySQLParserExecutor;
import com.glodon.translator.parser.statement.SQLStatement;

public class MySQLParserTest {

    public static void main(String[] args) {
        MySQLParserExecutor executor = new MySQLParserExecutor();
        SQLStatement statement = executor.parse("CREATE TABLE TEST (\n" +
                "id int(11) NOT NULL,\n" +
                "name varchar(20),\n" +
                "modifytime timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP\n" +
                ");", false);
        System.out.println(statement);
    }
}
