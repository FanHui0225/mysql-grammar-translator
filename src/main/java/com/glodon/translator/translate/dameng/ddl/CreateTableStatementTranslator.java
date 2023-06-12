package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateTableStatement;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Collection;

public class CreateTableStatementTranslator extends SQLStatementTranslator<MySQLCreateTableStatement> {

    public CreateTableStatementTranslator() {
        append("CREATE").appendBlankSpace().append("TABLE").appendBlankSpace();
    }

    @Override
    public String translate(MySQLCreateTableStatement statement) {
        SimpleTableSegment tableSegment = statement.getTable();
        IdentifierValue tableName;
        if (null == tableSegment || null == (tableName = tableSegment.getTableName())) {
            throw new SQLTranslatorException("table segment required.");
        }
        if (tableSegment.getOwner().isPresent()) {
            append(tableSegment.getOwner().get().getIdentifier().getValue()).append('.');
        }
        append(tableName.getValue());
        appendLineFeed().append('(');
        Collection<ColumnDefinitionSegment> columnDefinitionSegments = statement.getColumnDefinitions();
        if (columnDefinitionSegments.isEmpty()) {
            throw new SQLTranslatorException("column definition required.");
        }
        columnDefinitionSegments.forEach(segment -> append(new CreateDefinitionSegmentTranslator().translate(segment)));
        append(")").appendLineFeed();
        return toString();
    }
}
