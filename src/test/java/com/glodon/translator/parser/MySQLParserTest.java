package com.glodon.translator.parser;

import com.glodon.translator.parser.dialect.mysql.MySQLParserExecutor;
import com.glodon.translator.parser.extractor.TableExtractor;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.dml.SelectStatement;
import com.glodon.translator.translate.dameng.MySQLToDamengStatementTranslator;

public class MySQLParserTest {

    public static void main(String[] args) throws InterruptedException {
        TableExtractor extractor = new TableExtractor();
        MySQLParserExecutor executor = new MySQLParserExecutor();
        for (int i = 0; i < 1; i++) {
            long start = System.currentTimeMillis();
            SQLStatement statement1 = executor.parse("CREATE TABLE TEST (\n" +
                    "id int(11) NOT NULL,\n" +
                    "name varchar(20) DEFAULT 'Beijing',\n" +
                    "modifytime timestamp(3) NOT NULL default (CURRENT_DATE + INTERVAL 1 YEAR) on update CURRENT_TIMESTAMP\n" +
                    ");", false);

            SQLStatement statement2 = executor.parse("SELECT id , name , age ,\n" +
                    "(@age:=@age + age ) as  age_sum\n" +
                    "FROM user , ( SELECT @age := 0  ) s\n" +
                    "ORDER BY id", false);
            SQLStatement statement3 = executor.parse(
                    "CREATE TEMPORARY TABLE `abc`.`deploy_engine_meta` (\n" +
                            "\t`id` varchar(100) NOT NULL PRIMARY KEY comment '引擎id' ,\n" +
                            "\t`engine_name` varchar(100) NOT NULL,\n" +
                            "\t`env_name` varchar(100) NOT NULL,\n" +
                            "\t`engine_status` INT NOT NULL AUTO_INCREMENT,\n" +
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

            SQLStatement statement4 = executor.parse("SELECT s2.`s_name`, s2.* FROM student AS s1,student AS s2 WHERE s1.`s_name`=s2.`big_borther`\n" +
                    "AND s1.`birth` = s2.`birth`;", false);

            SQLStatement statement5 = executor.parse("SELECT * FROM emp WHERE e_sai > (SELECT MAX(e_sai) FROM emp WHERE department=10)\n" +
                    "AND department != 10;", false);
            System.out.println(statement1);
            System.out.println(statement2);
            System.out.println(statement3);
            System.out.println(statement4);
            System.out.println(statement5);
            extractor.extractTablesFromSelect((SelectStatement) statement2);
            System.out.println("开销" + (System.currentTimeMillis() - start) + "ms");
            System.out.println(new MySQLToDamengStatementTranslator().translate(statement3));
            Thread.sleep(1000);
        }
    }
}
