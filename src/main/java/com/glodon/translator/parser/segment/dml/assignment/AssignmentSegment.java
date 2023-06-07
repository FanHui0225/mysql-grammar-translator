package com.glodon.translator.parser.segment.dml.assignment;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;

import java.util.List;

public interface AssignmentSegment extends SQLSegment {

    List<ColumnSegment> getColumns();

    ExpressionSegment getValue();
}
