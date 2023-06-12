package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.segment.ddl.CreateDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.ConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.DataTypeSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

public class CreateDefinitionSegmentTranslator extends SQLSegmentTranslator<CreateDefinitionSegment> {

    public CreateDefinitionSegmentTranslator() {
        appendIndent();
    }

    @Override
    public String translate(CreateDefinitionSegment statement) {
        if (statement instanceof ColumnDefinitionSegment) {
            ColumnDefinitionSegment columnDefinitionSegment = (ColumnDefinitionSegment) statement;
            ColumnSegment columnSegment = columnDefinitionSegment.getColumnName();
            if (null == columnSegment) {
                throw new SQLTranslatorException("create column name definition required.");
            }
            append(columnSegment.getIdentifier().getValue());
            appendIndent();
            DataTypeSegment typeSegment = columnDefinitionSegment.getDataType();
            if (null == typeSegment) {
                throw new SQLTranslatorException("create column type definition required.");
            }
            append(new DataTypeSegmentTranslator().translate(typeSegment));
        } else if (statement instanceof ConstraintDefinitionSegment) {

        } else {
            throw new SQLTranslatorException("create definition error.");
        }
        return toString();
    }

}
