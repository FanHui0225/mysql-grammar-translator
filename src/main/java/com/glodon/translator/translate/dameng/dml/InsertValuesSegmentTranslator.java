package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.segment.dml.assignment.InsertValuesSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.CommonExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.simple.LiteralExpressionSegment;
import com.glodon.translator.translate.SQLSegmentTranslator;
import com.glodon.translator.translate.SQLTranslatorException;

import java.util.Iterator;
import java.util.List;

public class InsertValuesSegmentTranslator extends SQLSegmentTranslator<InsertValuesSegment> {

    @Override
    public String translate(InsertValuesSegment insertValuesSegment) {
        append('(');
        List<ExpressionSegment> expressionSegments = insertValuesSegment.getValues();
        Iterator<ExpressionSegment> it = expressionSegments.iterator();
        while (it.hasNext()) {
            ExpressionSegment expression = it.next();
            if (expression instanceof LiteralExpressionSegment) {
                LiteralExpressionSegment literalExpressionSegment = (LiteralExpressionSegment) expression;
                Object value = literalExpressionSegment.getLiterals();
                if (value instanceof String) {
                    append(new StringBuilder().append('\'').append(value).append('\''));
                } else {
                    append(String.valueOf(value));
                }
            } else if (expression instanceof CommonExpressionSegment) {
                CommonExpressionSegment commonExpressionSegment = (CommonExpressionSegment) expression;
                append(commonExpressionSegment.getText());
            } else {
                throw new SQLTranslatorException("set assignment expression value error.");
            }
            if (it.hasNext()) {
                append(',').appendBlankSpace();
            }
        }
        append(')');
        return toString();
    }
}
