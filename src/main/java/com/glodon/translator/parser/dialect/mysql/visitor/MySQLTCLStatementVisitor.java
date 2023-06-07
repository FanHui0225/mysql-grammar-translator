package com.glodon.translator.parser.dialect.mysql.visitor;

import com.glodon.translator.antlr4.MySQLStatementParser.*;
import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.dialect.mysql.statement.tcl.*;
import com.glodon.translator.parser.enums.OperationScope;
import com.glodon.translator.parser.enums.TransactionAccessType;
import com.glodon.translator.parser.enums.TransactionIsolationLevel;
import com.glodon.translator.parser.segment.generic.AliasSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.segment.tcl.AutoCommitSegment;
import com.glodon.translator.parser.statement.tcl.xa.*;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.parser.visitor.statement.type.TCLStatementVisitor;
import org.antlr.v4.runtime.Token;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class MySQLTCLStatementVisitor extends MySQLStatementVisitor implements TCLStatementVisitor {

    @Override
    public ASTNode visitSetTransaction(final SetTransactionContext ctx) {
        MySQLSetTransactionStatement result = new MySQLSetTransactionStatement();
        if (null != ctx.optionType()) {
            OperationScope scope = null;
            if (null != ctx.optionType().SESSION()) {
                scope = OperationScope.SESSION;
            } else if (null != ctx.optionType().GLOBAL()) {
                scope = OperationScope.GLOBAL;
            }
            result.setScope(scope);
        }
        if (null != ctx.transactionCharacteristics().isolationLevel()) {
            TransactionIsolationLevel isolationLevel = null;
            if (null != ctx.transactionCharacteristics().isolationLevel().isolationTypes().SERIALIZABLE()) {
                isolationLevel = TransactionIsolationLevel.SERIALIZABLE;
            } else if (null != ctx.transactionCharacteristics().isolationLevel().isolationTypes().COMMITTED()) {
                isolationLevel = TransactionIsolationLevel.READ_COMMITTED;
            } else if (null != ctx.transactionCharacteristics().isolationLevel().isolationTypes().UNCOMMITTED()) {
                isolationLevel = TransactionIsolationLevel.READ_UNCOMMITTED;
            } else if (null != ctx.transactionCharacteristics().isolationLevel().isolationTypes().REPEATABLE()) {
                isolationLevel = TransactionIsolationLevel.REPEATABLE_READ;
            }
            result.setIsolationLevel(isolationLevel);
        }
        if (null != ctx.transactionCharacteristics().transactionAccessMode()) {
            TransactionAccessType accessType = null;
            if (null != ctx.transactionCharacteristics().transactionAccessMode().ONLY()) {
                accessType = TransactionAccessType.READ_ONLY;
            } else if (null != ctx.transactionCharacteristics().transactionAccessMode().WRITE()) {
                accessType = TransactionAccessType.READ_WRITE;
            }
            result.setAccessMode(accessType);
        }
        return result;
    }

    @Override
    public ASTNode visitSetAutoCommit(final SetAutoCommitContext ctx) {
        MySQLSetAutoCommitStatement result = new MySQLSetAutoCommitStatement();
        result.setAutoCommit(generateAutoCommitSegment(ctx.autoCommitValue).isAutoCommit());
        return result;
    }

    private AutoCommitSegment generateAutoCommitSegment(final Token ctx) {
        boolean autoCommit = "1".equals(ctx.getText()) || "ON".equals(ctx.getText());
        return new AutoCommitSegment(ctx.getStartIndex(), ctx.getStopIndex(), autoCommit);
    }

    @Override
    public ASTNode visitBeginTransaction(final BeginTransactionContext ctx) {
        return new MySQLBeginTransactionStatement();
    }

    @Override
    public ASTNode visitCommit(final CommitContext ctx) {
        return new MySQLCommitStatement();
    }

    @Override
    public ASTNode visitRollback(final RollbackContext ctx) {
        MySQLRollbackStatement result = new MySQLRollbackStatement();
        if (null != ctx.identifier()) {
            result.setSavepointName(((IdentifierValue) visit(ctx.identifier())).getValue());
        }
        return result;
    }

    @Override
    public ASTNode visitSavepoint(final SavepointContext ctx) {
        MySQLSavepointStatement result = new MySQLSavepointStatement();
        result.setSavepointName(((IdentifierValue) visit(ctx.identifier())).getValue());
        return result;
    }

    @Override
    public ASTNode visitReleaseSavepoint(final ReleaseSavepointContext ctx) {
        MySQLReleaseSavepointStatement result = new MySQLReleaseSavepointStatement();
        result.setSavepointName(((IdentifierValue) visit(ctx.identifier())).getValue());
        return result;
    }

    @Override
    public ASTNode visitXaBegin(final XaBeginContext ctx) {
        return new XABeginStatement(ctx.xid().getText());
    }

    @Override
    public ASTNode visitXaPrepare(final XaPrepareContext ctx) {
        return new XAPrepareStatement(ctx.xid().getText());
    }

    @Override
    public ASTNode visitXaCommit(final XaCommitContext ctx) {
        return new XACommitStatement(ctx.xid().getText());
    }

    @Override
    public ASTNode visitXaRollback(final XaRollbackContext ctx) {
        return new XARollbackStatement(ctx.xid().getText());
    }

    @Override
    public ASTNode visitXaEnd(final XaEndContext ctx) {
        return new XAEndStatement(ctx.xid().getText());
    }

    @Override
    public ASTNode visitXaRecovery(final XaRecoveryContext ctx) {
        return new XARecoveryStatement();
    }

    @Override
    public ASTNode visitLock(final LockContext ctx) {
        MySQLLockStatement result = new MySQLLockStatement();
        if (null != ctx.tableLock()) {
            result.getTables().addAll(getLockTables(ctx.tableLock()));
        }
        return result;
    }

    private Collection<SimpleTableSegment> getLockTables(final List<TableLockContext> tableLockContexts) {
        Collection<SimpleTableSegment> result = new LinkedList<>();
        for (TableLockContext each : tableLockContexts) {
            SimpleTableSegment simpleTableSegment = (SimpleTableSegment) visit(each.tableName());
            if (null != each.alias()) {
                simpleTableSegment.setAlias((AliasSegment) visit(each.alias()));
            }
            result.add(simpleTableSegment);
        }
        return result;
    }

    @Override
    public ASTNode visitUnlock(final UnlockContext ctx) {
        return new MySQLUnlockStatement();
    }
}
