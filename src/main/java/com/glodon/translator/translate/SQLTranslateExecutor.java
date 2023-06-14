package com.glodon.translator.translate;

import com.glodon.translator.parser.SQLParserExecutor;
import com.glodon.translator.parser.statement.SQLStatement;

public abstract class SQLTranslateExecutor extends SQLParserExecutor {

    public final String translate(final SQLStatement statement) {
        return makeSQLStatementTranslator(statement).translate(statement);
    }

    public final String translate(final String sql) {
        return this.translate(sql, false);
    }

    public final String translate(final String sql, boolean useCache) {
        SQLStatement statement = parse(sql, useCache);
        return translate(statement);
    }

    protected abstract SQLStatementTranslator<SQLStatement> makeSQLStatementTranslator(SQLStatement statement);
}

