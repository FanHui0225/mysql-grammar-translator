package com.glodon.translator.translate;

import com.glodon.translator.parser.statement.SQLStatement;

public interface SQLStatementTranslatorFactory {

    SQLStatementTranslator<SQLStatement> create(SQLStatement statement);

}
