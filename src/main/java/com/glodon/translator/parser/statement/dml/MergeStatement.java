
package com.glodon.translator.parser.statement.dml;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.generic.table.TableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

public abstract class MergeStatement extends AbstractSQLStatement implements DMLStatement {

    private TableSegment target;

    private TableSegment source;

    private ExpressionSegment expr;

    private UpdateStatement update;

    private DeleteStatement delete;

    public TableSegment getTarget() {
        return target;
    }

    public void setTarget(TableSegment target) {
        this.target = target;
    }

    public TableSegment getSource() {
        return source;
    }

    public void setSource(TableSegment source) {
        this.source = source;
    }

    public ExpressionSegment getExpr() {
        return expr;
    }

    public void setExpr(ExpressionSegment expr) {
        this.expr = expr;
    }

    public UpdateStatement getUpdate() {
        return update;
    }

    public void setUpdate(UpdateStatement update) {
        this.update = update;
    }

    public DeleteStatement getDelete() {
        return delete;
    }

    public void setDelete(DeleteStatement delete) {
        this.delete = delete;
    }
}
