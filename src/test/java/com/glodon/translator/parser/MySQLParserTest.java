package com.glodon.translator.parser;

import com.glodon.translator.parser.dialect.mysql.MySQLParserExecutor;
import com.glodon.translator.parser.extractor.TableExtractor;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public class MySQLParserTest {

    public static void main(String[] args) {
        TableExtractor extractor = new TableExtractor();
        MySQLParserExecutor executor = new MySQLParserExecutor();
        SQLStatement statement1 = executor.parse("CREATE TABLE TEST (\n" +
                "id int(11) NOT NULL,\n" +
                "name varchar(20) DEFAULT 'Beijing',\n" +
                "modifytime timestamp(3) NOT NULL default (CURRENT_DATE + INTERVAL 1 YEAR) on update CURRENT_TIMESTAMP\n" +
                ");", false);

        SQLStatement statement2 = executor.parse("SELECT id , name , age ,\n" +
                "(@age:=@age + age ) as  age_sum\n" +
                "FROM user , ( SELECT @age := 0  ) s\n" +
                "ORDER BY id", false);
        SQLStatement statement3 = executor.parse("CREATE TABLE `deploy_engine_meta` (\n" +
                "\t`id` varchar(100) NOT NULL comment '引擎id' ,\n" +
                "\t`engine_name` varchar(100) NOT NULL,\n" +
                "\t`env_name` varchar(100) NOT NULL,\n" +
                "\t`engine_status` INT NOT NULL,\n" +
                "\t`engine_sign` varchar(255) NOT NULL,\n" +
                "  `pivot_meta_id` varchar(100) NOT NULL,\n" +
                "  `version` bigint(20) NOT NULL DEFAULT 0,\n" +
                "\t`created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "\t`updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
                "\tPRIMARY KEY (`id`)\n" +
                ")\n" +
                "ENGINE=InnoDB\n" +
                "DEFAULT CHARSET=utf8mb4\n" +
                "COLLATE=utf8mb4_unicode_ci;", false);
        System.out.println(statement1);
        System.out.println(statement2);
        System.out.println(statement3);
        extractor.extractTablesFromSelect((SelectStatement) statement2);
        System.out.println();
    }
}
