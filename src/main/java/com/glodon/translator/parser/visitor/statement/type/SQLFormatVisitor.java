package com.glodon.translator.parser.visitor.statement.type;

import com.glodon.translator.parser.visitor.SQLVisitor;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public interface SQLFormatVisitor extends SQLVisitor<String> {

    default void init(Properties props) {
    }

    default Collection<String> getTypeAliases() {
        return Collections.emptyList();
    }

    default boolean isDefault() {
        return false;
    }
}
