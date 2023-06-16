package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.column.InsertColumnsSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;

import java.util.Collection;
import java.util.Iterator;

public class InsertColumnsSegmentTranslator extends SQLSegmentTranslator<InsertColumnsSegment> {

    @Override
    public String translate(InsertColumnsSegment insertColumnsSegment) {
        Collection<ColumnSegment> columnSegments = insertColumnsSegment.getColumns();
        Iterator<ColumnSegment> it = columnSegments.iterator();
        append('(');
        while (it.hasNext()) {
            ColumnSegment columnSegment = it.next();
            append(columnSegment.getIdentifier().getValue().toUpperCase());
            if (it.hasNext()) {
                String sep = ", ";
                append(sep);
            }
        }
        append(')');
        return toString();
    }
}
