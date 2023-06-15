package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.dialect.mysql.statement.dml.MySQLInsertStatement;
import com.glodon.translator.parser.segment.dml.assignment.InsertValuesSegment;
import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.column.OnDuplicateKeyColumnsSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.translate.SQLStatementTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Collection;
import java.util.Optional;

public class InsertStatementTranslator extends SQLStatementTranslator<MySQLInsertStatement> {

    public InsertStatementTranslator() {
        append("INSERT").appendBlankSpace().append("INTO").appendBlankSpace();
    }

    @Override
    public String translate(MySQLInsertStatement statement) {
        SimpleTableSegment tableSegment = statement.getTable();
        IdentifierValue tableName;
        if (null == tableSegment || null == (tableName = tableSegment.getTableName())) {
            throw new SQLTranslatorException("table segment required.");
        }
        if (tableSegment.getOwner().isPresent()) {
            append(tableSegment.getOwner().get().getIdentifier().getValue().toUpperCase()).append('.');
        }
        append(tableName.getValue().toUpperCase()).appendBlankSpace();
        Collection<InsertValuesSegment> valuesSegments = statement.getValues();
        Optional<SetAssignmentSegment> setAssignmentSegment = statement.getSetAssignment();
        Optional<OnDuplicateKeyColumnsSegment> onDuplicateKeyColumnsSegment = statement.getOnDuplicateKeyColumns();
        return null;
    }
}
