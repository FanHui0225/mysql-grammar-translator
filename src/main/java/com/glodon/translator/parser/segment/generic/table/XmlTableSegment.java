
package com.glodon.translator.parser.segment.generic.table;

import com.glodon.translator.parser.segment.dml.expr.XmlTableFunctionSegment;
import com.glodon.translator.parser.segment.generic.AliasSegment;

import java.util.Optional;

public final class XmlTableSegment implements TableSegment {

    private final int startIndex;

    private final int stopIndex;

    private final String tableName;

    private final String tableNameAlias;

    private final XmlTableFunctionSegment xmlTableFunction;

    private final String xmlTableFunctionAlias;


    public XmlTableSegment(int startIndex, int stopIndex, String tableName, String tableNameAlias, XmlTableFunctionSegment xmlTableFunction, String xmlTableFunctionAlias) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.tableName = tableName;
        this.tableNameAlias = tableNameAlias;
        this.xmlTableFunction = xmlTableFunction;
        this.xmlTableFunctionAlias = xmlTableFunctionAlias;
    }

    @Override
    public Optional<String> getAliasName() {
        return Optional.empty();
    }

    @Override
    public Optional<AliasSegment> getAlias() {
        return Optional.empty();
    }

    @Override
    public void setAlias(final AliasSegment alias) {
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableNameAlias() {
        return tableNameAlias;
    }

    public XmlTableFunctionSegment getXmlTableFunction() {
        return xmlTableFunction;
    }

    public String getXmlTableFunctionAlias() {
        return xmlTableFunctionAlias;
    }
}
