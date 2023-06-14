package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.dialect.mysql.statement.ddl.MySQLCreateTableStatement;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.generic.OwnerSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Collection;
import java.util.Iterator;

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
            append(tableSegment.getOwner().get().getIdentifier().getValue().toUpperCase()).append('.');
        }
        append(tableName.getValue().toUpperCase()).appendBlankSpace().append('(').appendLineFeed();
        Collection<ColumnDefinitionSegment> columnDefinitionSegments = statement.getColumnDefinitions();
        if (columnDefinitionSegments.isEmpty()) {
            throw new SQLTranslatorException("column definition required.");
        }
        Iterator<ColumnDefinitionSegment> it = columnDefinitionSegments.iterator();
        boolean hasAutoInc = false;
        while (it.hasNext()) {
            ColumnDefinitionSegment definitionSegment = it.next();
            CreateDefinitionSegmentTranslator createDefinitionSegmentTranslator = new CreateDefinitionSegmentTranslator(it.hasNext());
            append(createDefinitionSegmentTranslator.translate(definitionSegment)).appendLineFeed();
            hasAutoInc |= createDefinitionSegmentTranslator.isAutoInc();

        }
        append(")");
        if (hasAutoInc) {
            appendLineFeed().append("AUTO_INCREMENT").append('=').append('0');
        }
        append(';');
        return toString();
    }
}
