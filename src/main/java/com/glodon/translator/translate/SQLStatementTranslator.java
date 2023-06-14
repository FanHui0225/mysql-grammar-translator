package com.glodon.translator.translate;

import com.glodon.translator.parser.statement.SQLStatement;

public abstract class SQLStatementTranslator<S extends SQLStatement> extends SQLTranslator<S> {

    public final SQLStatementTranslator<SQLStatement> _this() {
        return (SQLStatementTranslator<SQLStatement>) this;
    }
}
