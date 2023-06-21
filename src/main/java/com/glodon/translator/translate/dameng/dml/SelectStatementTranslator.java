package com.glodon.translator.translate.dameng.dml;

import com.glodon.translator.parser.segment.dml.item.ProjectionsSegment;
import com.glodon.translator.parser.statement.dml.SelectStatement;
import com.glodon.translator.translate.SQLStatementTranslator;

public class SelectStatementTranslator extends SQLStatementTranslator<SelectStatement> {

    @Override
    public String translate(SelectStatement statement) {
        append("SELECT").appendBlankSpace();
        ProjectionsSegment projectionsSegment = statement.getProjections();

        //TODO
        return null;
    }
}
