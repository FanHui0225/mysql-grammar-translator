package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.segment.ddl.CreateDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.column.ColumnDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.ConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.generic.DataTypeSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

public class CreateDefinitionSegmentTranslator extends SQLSegmentTranslator<CreateDefinitionSegment> {

    private boolean fillEndSymbol;
    private boolean autoInc;

    public CreateDefinitionSegmentTranslator() {
        this(true);
    }

    public CreateDefinitionSegmentTranslator(boolean fillEndSymbol) {
        this.fillEndSymbol = fillEndSymbol;
    }

    @Override
    public String translate(CreateDefinitionSegment statement) {
        if (statement instanceof ColumnDefinitionSegment) {
            ColumnDefinitionSegment columnDefinitionSegment = (ColumnDefinitionSegment) statement;
            ColumnSegment columnSegment = columnDefinitionSegment.getColumnName();
            if (null == columnSegment) {
                throw new SQLTranslatorException("create column name definition required.");
            }
            appendIndent().append(columnSegment.getIdentifier().getValue()).appendBlankSpace();
            DataTypeSegment typeSegment = columnDefinitionSegment.getDataType();
            if (null == typeSegment) {
                throw new SQLTranslatorException("create column type definition required.");
            }
            DataTypeSegmentTranslator dataTypeSegmentTranslator = new DataTypeSegmentTranslator();
            append(dataTypeSegmentTranslator.translate(typeSegment));

            if (columnDefinitionSegment.isNotNull()) {
                appendBlankSpace().append("NOT").appendBlankSpace().append("NULL");
            }
            if (columnDefinitionSegment.getDefaultValue() != null) {
                appendBlankSpace().append("DEFAULT").appendBlankSpace().append(String.valueOf(columnDefinitionSegment.getDefaultValue().getValue()));
            }
            if (columnDefinitionSegment.isPrimaryKey()) {
                appendBlankSpace().append("PRIMARY").appendBlankSpace().append("KEY");
            }
            if (columnDefinitionSegment.isAutoInc()) {
                String dataType = dataTypeSegmentTranslator.getDataType();
                switch (dataType) {
                    case "TINYINT":
                    case "SMALLINT":
                    case "INT":
                    case "BIGINT":
                        appendBlankSpace().append("AUTO_INCREMENT");
                        this.autoInc = true;
                        break;
                    default:
                        this.autoInc = false;
                        break;
                }
            }
            if (columnDefinitionSegment.getCommentValue() != null) {
                appendBlankSpace().append("COMMENT").appendBlankSpace().append(columnDefinitionSegment.getCommentValue().getValue());
            }
            if (isFillEndSymbol()) {
                append(',');
            }
        } else if (statement instanceof ConstraintDefinitionSegment) {

        } else {
            throw new SQLTranslatorException("create definition error.");
        }
        return toString();
    }

    public boolean isFillEndSymbol() {
        return fillEndSymbol;
    }

    public boolean isAutoInc() {
        return autoInc;
    }
}
