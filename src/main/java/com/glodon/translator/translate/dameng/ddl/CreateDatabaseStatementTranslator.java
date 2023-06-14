package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateDatabaseStatement;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslatorException;
import org.apache.groovy.parser.antlr4.util.StringUtils;

public class CreateDatabaseStatementTranslator extends SQLStatementTranslator<MySQLCreateDatabaseStatement> {

    @Override
    public String translate(MySQLCreateDatabaseStatement statement) {
        String databaseName = statement.getDatabaseName();
        if (StringUtils.isEmpty(databaseName)) {
            throw new SQLTranslatorException("create database name required.");
        }
        append("CREATE")
                .appendBlankSpace()
                .append("SCHEMA")
                .appendBlankSpace()
                .append(databaseName.toUpperCase())
                .appendBlankSpace()
                .append("AUTHORIZATION")
                .appendBlankSpace()
                .append("SYSDBA")
                .append(';');
        return toString();
    }
}
