package com.glodon.translator.translate;

import com.glodon.translator.parser.statement.SQLStatement;

public interface SQLTranslator {

    String translate(SQLStatement statement);
}
