package com.glodon.translator.parser.segment.ddl.table;

import com.glodon.translator.parser.segment.ddl.AlterDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.charset.CharsetNameSegment;
import com.glodon.translator.parser.segment.dml.expr.simple.SimpleExpressionSegment;

public final class ConvertTableDefinitionSegment implements AlterDefinitionSegment {

    private final int startIndex;

    private final int stopIndex;

    private final CharsetNameSegment charsetName;

    private SimpleExpressionSegment collateValue;

    public ConvertTableDefinitionSegment(int startIndex, int stopIndex, CharsetNameSegment charsetName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.charsetName = charsetName;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public CharsetNameSegment getCharsetName() {
        return charsetName;
    }

    public SimpleExpressionSegment getCollateValue() {
        return collateValue;
    }

    public void setCollateValue(SimpleExpressionSegment collateValue) {
        this.collateValue = collateValue;
    }
}
