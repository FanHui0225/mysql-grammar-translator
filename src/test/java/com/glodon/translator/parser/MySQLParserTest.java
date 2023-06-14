package com.glodon.translator.parser;

import com.glodon.translator.MySQLToDamengSQLFacade;
import com.glodon.translator.parser.extractor.TableExtractor;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;

public class MySQLParserTest {

    public static void main(String[] args) throws InterruptedException {
        TableExtractor extractor = new TableExtractor();
        MySQLToDamengSQLFacade facade = new MySQLToDamengSQLFacade();
        for (int i = 0; i < 1; i++) {
            long start = System.currentTimeMillis();
            SQLStatement statement1 = facade.parse("CREATE TABLE TEST (\n" +
                    "id int(11) NOT NULL,\n" +
                    "name varchar(20) DEFAULT 'Beijing',\n" +
                    "modifytime timestamp(3) NOT NULL default (CURRENT_DATE + INTERVAL 1 YEAR) on update CURRENT_TIMESTAMP\n" +
                    ");", false);

            SQLStatement statement2 = facade.parse("SELECT id , name , age ,\n" +
                    "(@age:=@age + age ) as  age_sum\n" +
                    "FROM user , ( SELECT @age := 0  ) s\n" +
                    "ORDER BY id", false);
            String sql3;
            SQLStatement statement3 = facade.parse(
                    sql3 = "CREATE TEMPORARY TABLE `ABC`.`deploy_engine_meta` (\n" +
                            "\t`id` bigint(100) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '引擎id' ,\n" +
                            "\t`engine_status` INT NOT NULL,\n" +
                            "\t`engine_name` varchar(100) NOT NULL,\n" +
                            "\t`env_name` varchar(100) NOT NULL,\n" +
                            "\t`engine_sign` varchar(255) NOT NULL,\n" +
                            "\t`pivot_meta_id` varchar(100) NOT NULL,\n" +
                            "\t`version` bigint(20) NOT NULL DEFAULT 0,\n" +
                            "\t`f2` FLOAT(5,2),\n" +
                            "\t`created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                            "\t`updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
                            "\tPRIMARY KEY (`id`)\n" +
                            ")\n" +
                            "ENGINE=InnoDB\n" +
                            "DEFAULT CHARSET=utf8mb4\n" +
                            "COLLATE=utf8mb4_unicode_ci;",
                    false);

            SQLStatement statement4 = facade.parse("SELECT s2.`s_name`, s2.* FROM student AS s1,student AS s2 WHERE s1.`s_name`=s2.`big_borther`\n" +
                    "AND s1.`birth` = s2.`birth`;", false);

            SQLStatement statement5 = facade.parse("SELECT * FROM emp WHERE e_sai > (SELECT MAX(e_sai) FROM emp WHERE department=10)\n" +
                    "AND department != 10;", false);

            String sql6;
            SQLStatement statement6 = facade.parse(sql6 = "CREATE DATABASE IF NOT EXISTS test_db_char DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_chinese_ci;", false);

            //萃取table
            extractor.extractTablesFromSelect((SelectStatement) statement2);
            start = System.currentTimeMillis();
            System.out.println(facade.translate(sql3));
            System.out.println(facade.translate(sql6));
            System.out.println("Dameng转换开销: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
