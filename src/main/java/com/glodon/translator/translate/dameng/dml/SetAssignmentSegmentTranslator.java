package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.segment.dml.assignment.AssignmentSegment;
import com.glodon.translator.parser.segment.dml.assignment.SetAssignmentSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.CommonExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.simple.LiteralExpressionSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Collection;
import java.util.Iterator;

public class SetAssignmentSegmentTranslator extends SQLSegmentTranslator<SetAssignmentSegment> {

    @Override
    public String translate(SetAssignmentSegment setAssignmentSegment) {
        Collection<AssignmentSegment> assignmentSegments = setAssignmentSegment.getAssignments();
        Iterator<AssignmentSegment> it = assignmentSegments.iterator();
        StringBuilder columnsSegmentSQL = new StringBuilder();
        columnsSegmentSQL.append('(');
        StringBuilder valuesSegmentSQL = new StringBuilder();
        valuesSegmentSQL.append("VALUES (");
        while (it.hasNext()) {
            AssignmentSegment assignmentSegment = it.next();
            String columnName = assignmentSegment.getColumns().get(0).getIdentifier().getValue();
            ExpressionSegment expression = assignmentSegment.getValue();
            columnsSegmentSQL.append(columnName.toUpperCase());
            if (expression instanceof LiteralExpressionSegment) {
                LiteralExpressionSegment literalExpressionSegment = (LiteralExpressionSegment) expression;
                Object value = literalExpressionSegment.getLiterals();
                valuesSegmentSQL.append(value instanceof String ? new StringBuilder().append('\'').append(value).append('\'') : String.valueOf(value));
            } else if (expression instanceof CommonExpressionSegment) {
                CommonExpressionSegment commonExpressionSegment = (CommonExpressionSegment) expression;
                valuesSegmentSQL.append(commonExpressionSegment.getText());
            } else
                throw new SQLTranslatorException("set assignment expression value error.");
            if (it.hasNext()) {
                String sep = ", ";
                columnsSegmentSQL.append(sep);
                valuesSegmentSQL.append(sep);
            }
        }
        columnsSegmentSQL.append(')');
        valuesSegmentSQL.append(')');
        append(columnsSegmentSQL.toString()).appendBlankSpace().append(valuesSegmentSQL.toString());
        return toString();
    }
}
