package com.glodon.translator.translate.dameng.ddl;

import com.glodon.translator.parser.segment.generic.DataTypeLengthSegment;
import com.glodon.translator.parser.segment.generic.DataTypeSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

public class DataTypeSegmentTranslator extends SQLSegmentTranslator<DataTypeSegment> {

    private String dataType;

    @Override
    public String translate(DataTypeSegment statement) {
        String type = statement.getDataTypeName().toUpperCase();
        DataTypeLengthSegment lengthSegment = statement.getDataLength();
        switch (type) {
            case "TINYINT":
                append("TINYINT");
                this.dataType = "TINYINT";
                break;
            case "SMALLINT":
                append("SMALLINT");
                this.dataType = "SMALLINT";
                break;
            case "MEDIUMINT":
            case "INTEGER":
            case "INT":
                append("INT");
                this.dataType = "INT";
                break;
            case "BIGINT":
                append("BIGINT");
                this.dataType = "BIGINT";
                break;
            case "REAL":
                append("REAL");
                this.dataType = "REAL";
                break;
            case "FLOAT":
            case "DOUBLE":
                if (null != lengthSegment) {
                    append("NUMBER")
                            .append('(').
                            append(lengthSegment.getPrecision())
                            .append(',')
                            .append(lengthSegment.getScale().get())
                            .append(')');
                } else {
                    append("NUMBER").append('(').append(16).append(',').append('4').append(')');
                }
                this.dataType = "NUMBER";
                break;
            case "NUMERIC":
            case "DECIMAL":
                if (null != lengthSegment) {
                    append(type)
                            .append('(')
                            .append(lengthSegment.getPrecision())
                            .append(',')
                            .append(lengthSegment.getScale().get())
                            .append(')');
                } else {
                    append(type).append('(').append(10).append(',').append('0').append(')');
                }
                this.dataType = type;
                break;
            case "DATE":
                append("DATE");
                break;
            case "DATETIME":
            case "TIMESTAMP":
            case "TIME":
                append(type).append('(').append('0').append(')');
                this.dataType = type;
                break;
            case "VARCHAR":
            case "CHAR":
                if (null != lengthSegment) {
                    append(type).append('(').append(lengthSegment.getPrecision()).append(')');
                } else {
                    append(type);
                }
                this.dataType = type;
                break;
            case "BLOB":
            case "TINYBLOB":
            case "MEDIUMBLOB":
            case "LONGBLOB":
                append("BLOB");
                this.dataType = "BLOB";
                break;
            case "TINYTEXT":
            case "TEXT":
            case "MEDIUMTEXT":
            case "LONGTEXT":
                append("TEXT");
                this.dataType = "TEXT";
                break;
            default:
                throw new SQLTranslatorException("data type: " + type + " not supported.");
        }
        return toString();
    }

    public String getDataType() {
        return dataType;
    }
}
