
package com.glodon.translator.parser.dialect.mysql.visitor;

import com.glodon.translator.antlr4.MySQLStatementParser.*;
import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.dialect.mysql.statement.dal.*;
import com.glodon.translator.parser.dialect.mysql.statement.segment.*;
import com.glodon.translator.parser.segment.dal.*;
import com.glodon.translator.parser.segment.ddl.index.IndexSegment;
import com.glodon.translator.parser.segment.dml.column.ColumnSegment;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.FunctionSegment;
import com.glodon.translator.parser.segment.dml.pagination.limit.LimitSegment;
import com.glodon.translator.parser.segment.dml.predicate.WhereSegment;
import com.glodon.translator.parser.segment.generic.DatabaseSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.value.collection.CollectionValue;
import com.glodon.translator.parser.value.identifier.IdentifierValue;
import com.glodon.translator.parser.value.literal.NumberLiteralValue;
import com.glodon.translator.parser.value.literal.StringLiteralValue;
import com.glodon.translator.parser.visitor.statement.type.DALStatementVisitor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class MySQLDALStatementVisitor extends MySQLStatementVisitor implements DALStatementVisitor {

    @Override
    public ASTNode visitUninstallPlugin(UninstallPluginContext ctx) {
        MySQLUninstallPluginStatement result = new MySQLUninstallPluginStatement();
        result.setPluginName(((IdentifierValue) visit(ctx.pluginName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitShowCreateDatabase(final ShowCreateDatabaseContext ctx) {
        MySQLShowCreateDatabaseStatement result = new MySQLShowCreateDatabaseStatement();
        result.setDatabaseName(((DatabaseSegment) visit(ctx.schemaName())).getIdentifier().getValue());
        return result;
    }

    @Override
    public ASTNode visitShowBinaryLogs(final ShowBinaryLogsContext ctx) {
        return new MySQLShowBinaryLogsStatement();
    }

    @Override
    public ASTNode visitShowStatus(final ShowStatusContext ctx) {
        MySQLShowStatusStatement result = new MySQLShowStatusStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowCreateView(final ShowCreateViewContext ctx) {
        return new MySQLShowCreateViewStatement();
    }

    @Override
    public ASTNode visitShowEngines(final ShowEnginesContext ctx) {
        return new MySQLShowOtherStatement();
    }

    @Override
    public ASTNode visitShowEngine(final ShowEngineContext ctx) {
        MySQLShowEngineStatement result = new MySQLShowEngineStatement();
        result.setEngineName(ctx.engineRef().getText());
        return result;
    }

    @Override
    public ASTNode visitShowCharset(final ShowCharsetContext ctx) {
        return new MySQLShowOtherStatement();
    }

    @Override
    public ASTNode visitShowCreateEvent(final ShowCreateEventContext ctx) {
        MySQLShowCreateEventStatement result = new MySQLShowCreateEventStatement();
        result.setEventName(((IdentifierValue) visit(ctx.eventName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitShowCreateFunction(final ShowCreateFunctionContext ctx) {
        MySQLShowCreateFunctionStatement result = new MySQLShowCreateFunctionStatement();
        result.setFunctionName(((FunctionSegment) visit(ctx.functionName())).getFunctionName());
        return result;
    }

    @Override
    public ASTNode visitShowCreateProcedure(final ShowCreateProcedureContext ctx) {
        MySQLShowCreateProcedureStatement result = new MySQLShowCreateProcedureStatement();
        result.setProcedureName(((IdentifierValue) visit(ctx.procedureName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitShowBinlogEvents(final ShowBinlogEventsContext ctx) {
        MySQLShowBinlogEventsStatement result = new MySQLShowBinlogEventsStatement();
        if (null != ctx.logName()) {
            result.setLogName(ctx.logName().getText());
        }
        if (null != ctx.limitClause()) {
            result.setLimit((LimitSegment) visit(ctx.limitClause()));
        }
        return result;
    }

    @Override
    public ASTNode visitShowErrors(final ShowErrorsContext ctx) {
        MySQLShowErrorsStatement result = new MySQLShowErrorsStatement();
        if (null != ctx.limitClause()) {
            result.setLimit((LimitSegment) visit(ctx.limitClause()));
        }
        return result;
    }

    @Override
    public ASTNode visitShowWarnings(final ShowWarningsContext ctx) {
        MySQLShowWarningsStatement result = new MySQLShowWarningsStatement();
        if (null != ctx.limitClause()) {
            result.setLimit((LimitSegment) visit(ctx.limitClause()));
        }
        return result;
    }

    @Override
    public ASTNode visitResetStatement(final ResetStatementContext ctx) {
        ResetPersistContext persistContext = ctx.resetPersist();
        if (null != persistContext) {
            return visit(persistContext);
        }
        MySQLResetStatement result = new MySQLResetStatement();
        for (ResetOptionContext each : ctx.resetOption()) {
            if (null != each.MASTER() || null != each.SLAVE()) {
                result.getOptions().add((ResetOptionSegment) visit(each));
            }
        }
        return result;
    }

    @Override
    public ASTNode visitResetPersist(final ResetPersistContext ctx) {
        return new MySQLResetPersistStatement(null != ctx.ifExists(), null == ctx.identifier() ? null : new IdentifierValue(ctx.identifier().getText()));
    }

    @Override
    public ASTNode visitResetOption(final ResetOptionContext ctx) {
        if (null != ctx.MASTER()) {
            ResetMasterOptionSegment result = new ResetMasterOptionSegment();
            if (null != ctx.binaryLogFileIndexNumber()) {
                result.setBinaryLogFileIndexNumber(((NumberLiteralValue) visit(ctx.binaryLogFileIndexNumber())).getValue().longValue());
            }
            result.setStartIndex(ctx.start.getStartIndex());
            result.setStopIndex(ctx.stop.getStopIndex());
            return result;
        }
        ResetSlaveOptionSegment result = new ResetSlaveOptionSegment();
        if (null != ctx.ALL()) {
            result.setAll(true);
        }
        if (null != ctx.channelOption()) {
            result.setChannelOption(((StringLiteralValue) visit(ctx.channelOption())).getValue());
        }
        result.setStartIndex(ctx.start.getStartIndex());
        result.setStopIndex(ctx.stop.getStopIndex());
        return result;
    }

    @Override
    public ASTNode visitChannelOption(final ChannelOptionContext ctx) {
        return visit(ctx.string_());
    }

    @Override
    public ASTNode visitBinaryLogFileIndexNumber(final BinaryLogFileIndexNumberContext ctx) {
        return new NumberLiteralValue(ctx.getText());
    }

    @Override
    public ASTNode visitShowReplicas(final ShowReplicasContext ctx) {
        return new MySQLShowReplicasStatement();
    }

    @SuppressWarnings("unchecked")
    @Override
    public ASTNode visitRepairTable(final RepairTableContext ctx) {
        MySQLRepairTableStatement result = new MySQLRepairTableStatement();
        result.getTables().addAll(((CollectionValue<SimpleTableSegment>) visit(ctx.tableList())).getValue());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ASTNode visitAnalyzeTable(final AnalyzeTableContext ctx) {
        MySQLAnalyzeTableStatement result = new MySQLAnalyzeTableStatement();
        result.getTables().addAll(((CollectionValue<SimpleTableSegment>) visit(ctx.tableList())).getValue());
        return result;
    }

    @Override
    public ASTNode visitCacheIndex(final CacheIndexContext ctx) {
        MySQLCacheIndexStatement result = new MySQLCacheIndexStatement();
        if (null != ctx.cacheTableIndexList()) {
            for (CacheTableIndexListContext each : ctx.cacheTableIndexList()) {
                result.getTableIndexes().add((CacheTableIndexSegment) visit(each));
            }
        }
        if (null != ctx.partitionList()) {
            SimpleTableSegment table = (SimpleTableSegment) visit(ctx.tableName());
            PartitionDefinitionSegment segment = new PartitionDefinitionSegment(ctx.tableName().getStart().getStartIndex(), ctx.partitionList().getStop().getStopIndex(), table);
            segment.getPartitions().addAll(((CollectionValue<PartitionSegment>) visit(ctx.partitionList())).getValue());
            result.setPartitionDefinition(segment);
        }
        result.setName((IdentifierValue) visit(ctx.identifier()));
        return result;
    }

    @Override
    public ASTNode visitCacheTableIndexList(final CacheTableIndexListContext ctx) {
        CacheTableIndexSegment result = new CacheTableIndexSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), (SimpleTableSegment) visit(ctx.tableName()));
        for (IndexNameContext each : ctx.indexName()) {
            result.getIndexes().add((IndexSegment) visitIndexName(each));
        }
        return result;
    }

    @Override
    public ASTNode visitPartitionList(final PartitionListContext ctx) {
        CollectionValue<PartitionSegment> result = new CollectionValue<>();
        for (PartitionNameContext each : ctx.partitionName()) {
            result.getValue().add((PartitionSegment) visit(each));
        }
        return result;
    }

    @Override
    public ASTNode visitPartitionName(final PartitionNameContext ctx) {
        return new PartitionSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), (IdentifierValue) visit(ctx.identifier()));
    }

    @Override
    public ASTNode visitChecksumTable(final ChecksumTableContext ctx) {
        MySQLChecksumTableStatement result = new MySQLChecksumTableStatement();
        result.getTables().addAll(((CollectionValue<SimpleTableSegment>) visit(ctx.tableList())).getValue());
        return result;
    }

    @Override
    public ASTNode visitFlush(final FlushContext ctx) {
        if (null != ctx.tablesOption()) {
            return visit(ctx.tablesOption());
        }
        return new MySQLFlushStatement();
    }

    @Override
    public ASTNode visitTablesOption(final TablesOptionContext ctx) {
        MySQLFlushStatement result = new MySQLFlushStatement();
        result.setFlushTable(true);
        for (TableNameContext each : ctx.tableName()) {
            result.getTables().add((SimpleTableSegment) visit(each));
        }
        return result;
    }

    @Override
    public ASTNode visitKill(final KillContext ctx) {
        MySQLKillStatement result = new MySQLKillStatement();
        if (null != ctx.AT_()) {
            result.setProcessId(ctx.AT_().getText().concat(ctx.IDENTIFIER_().getText()));
        } else {
            result.setProcessId(ctx.IDENTIFIER_().getText());
        }
        return result;
    }

    @Override
    public ASTNode visitLoadIndexInfo(final LoadIndexInfoContext ctx) {
        MySQLLoadIndexInfoStatement result = new MySQLLoadIndexInfoStatement();
        for (LoadTableIndexListContext each : ctx.loadTableIndexList()) {
            result.getTableIndexes().add((LoadTableIndexSegment) visit(each));
        }
        return result;
    }

    @Override
    public ASTNode visitLoadTableIndexList(final LoadTableIndexListContext ctx) {
        LoadTableIndexSegment result = new LoadTableIndexSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), (SimpleTableSegment) visit(ctx.tableName()));
        if (null != ctx.indexName()) {
            for (IndexNameContext each : ctx.indexName()) {
                result.getIndexes().add((IndexSegment) visitIndexName(each));
            }
        }
        if (null != ctx.partitionList()) {
            result.getPartitions().addAll(((CollectionValue<PartitionSegment>) visit(ctx.partitionList())).getValue());
        }
        return result;
    }

    @Override
    public ASTNode visitInstallPlugin(final InstallPluginContext ctx) {
        MySQLInstallPluginStatement result = new MySQLInstallPluginStatement();
        result.setPluginName(((IdentifierValue) visit(ctx.pluginName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitClone(final CloneContext ctx) {
        MySQLCloneStatement result = new MySQLCloneStatement();
        result.setCloneActionSegment((CloneActionSegment) visit(ctx.cloneAction()));
        return result;
    }

    @Override
    public ASTNode visitCloneAction(final CloneActionContext ctx) {
        CloneActionSegment result = new CloneActionSegment(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
        if (null != ctx.cloneInstance()) {
            CloneInstanceContext cloneInstance = ctx.cloneInstance();
            CloneInstanceSegment cloneInstanceSegment = new CloneInstanceSegment(cloneInstance.start.getStartIndex(), cloneInstance.stop.getStopIndex());
            cloneInstanceSegment.setUsername(((StringLiteralValue) visitUsername(cloneInstance.username())).getValue());
            cloneInstanceSegment.setHostname(((StringLiteralValue) visit(cloneInstance.hostname())).getValue());
            cloneInstanceSegment.setPort(new NumberLiteralValue(cloneInstance.port().NUMBER_().getText()).getValue().intValue());
            cloneInstanceSegment.setPassword(((StringLiteralValue) visit(ctx.string_())).getValue());
            if (null != ctx.SSL() && null == ctx.NO()) {
                cloneInstanceSegment.setSslRequired(true);
            }
            result.setCloneInstance(cloneInstanceSegment);
        }
        if (null != ctx.cloneDir()) {
            result.setCloneDir(((StringLiteralValue) visit(ctx.cloneDir())).getValue());
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ASTNode visitOptimizeTable(final OptimizeTableContext ctx) {
        MySQLOptimizeTableStatement result = new MySQLOptimizeTableStatement();
        result.getTables().addAll(((CollectionValue<SimpleTableSegment>) visit(ctx.tableList())).getValue());
        return result;
    }

    @Override
    public ASTNode visitUse(final UseContext ctx) {
        MySQLUseStatement result = new MySQLUseStatement();
        result.setSchema(((DatabaseSegment) visit(ctx.schemaName())).getIdentifier().getValue());
        return result;
    }

    @Override
    public ASTNode visitExplain(final ExplainContext ctx) {
        MySQLExplainStatement result = new MySQLExplainStatement();
        if (null != ctx.tableName()) {
            result.setTable((SimpleTableSegment) visit(ctx.tableName()));
            if (null != ctx.columnRef()) {
                result.setColumnWild((ColumnSegment) visit(ctx.columnRef()));
            } else if (null != ctx.textString()) {
                result.setColumnWild((ColumnSegment) visit(ctx.textString()));
            }
        } else if (null != ctx.explainableStatement()) {
            result.setStatement((SQLStatement) visit(ctx.explainableStatement()));
        } else if (null != ctx.select()) {
            result.setStatement((SQLStatement) visit(ctx.select()));
        } else if (null != ctx.delete()) {
            result.setStatement((SQLStatement) visit(ctx.delete()));
        } else if (null != ctx.update()) {
            result.setStatement((SQLStatement) visit(ctx.update()));
        } else if (null != ctx.insert()) {
            result.setStatement((SQLStatement) visit(ctx.insert()));
        }
        return result;
    }

    @Override
    public ASTNode visitExplainableStatement(final ExplainableStatementContext ctx) {
        if (null != ctx.select()) {
            return visit(ctx.select());
        }
        if (null != ctx.delete()) {
            return visit(ctx.delete());
        }
        if (null != ctx.insert()) {
            return visit(ctx.insert());
        }
        if (null != ctx.replace()) {
            return visit(ctx.replace());
        }
        return visit(ctx.update());
    }

    @Override
    public ASTNode visitShowProcedureCode(final ShowProcedureCodeContext ctx) {
        MySQLShowProcedureCodeStatement result = new MySQLShowProcedureCodeStatement();
        result.setFunction((FunctionSegment) visit(ctx.functionName()));
        return result;
    }

    @Override
    public ASTNode visitShowProfile(final ShowProfileContext ctx) {
        MySQLShowProfileStatement result = new MySQLShowProfileStatement();
        if (null != ctx.limitClause()) {
            result.setLimit((LimitSegment) visit(ctx.limitClause()));
        }
        return result;
    }

    @Override
    public ASTNode visitShowProfiles(final ShowProfilesContext ctx) {
        return new MySQLShowProfilesStatement();
    }

    @Override
    public ASTNode visitShowDatabases(final ShowDatabasesContext ctx) {
        MySQLShowDatabasesStatement result = new MySQLShowDatabasesStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowEvents(final ShowEventsContext ctx) {
        MySQLShowEventsStatement result = new MySQLShowEventsStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowTables(final ShowTablesContext ctx) {
        MySQLShowTablesStatement result = new MySQLShowTablesStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.setContainsFull(null != ctx.FULL());
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowTriggers(final ShowTriggersContext ctx) {
        MySQLShowTriggersStatement result = new MySQLShowTriggersStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowWhereClause(final ShowWhereClauseContext ctx) {
        return new WhereSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), (ExpressionSegment) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitShowTableStatus(final ShowTableStatusContext ctx) {
        MySQLShowTableStatusStatement result = new MySQLShowTableStatusStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowColumns(final ShowColumnsContext ctx) {
        MySQLShowColumnsStatement result = new MySQLShowColumnsStatement();
        if (null != ctx.fromTable()) {
            result.setTable(((FromTableSegment) visit(ctx.fromTable())).getTable());
        }
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowFilter(final ShowFilterContext ctx) {
        ShowFilterSegment result = new ShowFilterSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex());
        if (null != ctx.showLike()) {
            result.setLike((ShowLikeSegment) visit(ctx.showLike()));
        }
        if (null != ctx.showWhereClause()) {
            result.setWhere((WhereSegment) visit(ctx.showWhereClause()));
        }
        return result;
    }

    @Override
    public ASTNode visitShowIndex(final ShowIndexContext ctx) {
        MySQLShowIndexStatement result = new MySQLShowIndexStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.fromTable()) {
            result.setTable(((FromTableSegment) visitFromTable(ctx.fromTable())).getTable());
        }
        return result;
    }

    @Override
    public ASTNode visitShowCreateTable(final ShowCreateTableContext ctx) {
        MySQLShowCreateTableStatement result = new MySQLShowCreateTableStatement();
        result.setTable((SimpleTableSegment) visit(ctx.tableName()));
        return result;
    }

    @Override
    public ASTNode visitShowCreateTrigger(final ShowCreateTriggerContext ctx) {
        MySQLShowCreateTriggerStatement result = new MySQLShowCreateTriggerStatement();
        result.setName(((IdentifierValue) visit(ctx.triggerName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitShowRelaylogEvent(final ShowRelaylogEventContext ctx) {
        MySQLShowRelayLogEventsStatement result = new MySQLShowRelayLogEventsStatement();
        if (null != ctx.logName()) {
            result.setLogName(((StringLiteralValue) visit(ctx.logName().stringLiterals().string_())).getValue());
        }
        if (null != ctx.limitClause()) {
            result.setLimit((LimitSegment) visit(ctx.limitClause()));
        }
        if (null != ctx.channelName()) {
            result.setChannel(((IdentifierValue) visit(ctx.channelName())).getValue());
        }
        return result;
    }

    @Override
    public ASTNode visitShowFunctionCode(final ShowFunctionCodeContext ctx) {
        MySQLShowFunctionCodeStatement result = new MySQLShowFunctionCodeStatement();
        result.setFunctionName(((FunctionSegment) visit(ctx.functionName())).getFunctionName());
        return result;
    }

    @Override
    public ASTNode visitShowGrants(final ShowGrantsContext ctx) {
        return new MySQLShowGrantsStatement();
    }

    @Override
    public ASTNode visitShowMasterStatus(final ShowMasterStatusContext ctx) {
        return new MySQLShowMasterStatusStatement();
    }

    @Override
    public ASTNode visitShowSlaveHosts(final ShowSlaveHostsContext ctx) {
        return new MySQLShowSlaveHostsStatement();
    }

    @Override
    public ASTNode visitShowReplicaStatus(final ShowReplicaStatusContext ctx) {
        MySQLShowReplicaStatusStatement result = new MySQLShowReplicaStatusStatement();
        if (null != ctx.channelName()) {
            result.setChannel(((IdentifierValue) visit(ctx.channelName())).getValue());
        }
        return result;
    }

    @Override
    public ASTNode visitShowSlaveStatus(final ShowSlaveStatusContext ctx) {
        MySQLShowSlaveStatusStatement result = new MySQLShowSlaveStatusStatement();
        if (null != ctx.channelName()) {
            result.setChannel(((IdentifierValue) visit(ctx.channelName())).getValue());
        }
        return result;
    }

    @Override
    public ASTNode visitCreateResourceGroup(final CreateResourceGroupContext ctx) {
        MySQLCreateResourceGroupStatement result = new MySQLCreateResourceGroupStatement();
        result.setGroupName(((IdentifierValue) visit(ctx.groupName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitBinlog(final BinlogContext ctx) {
        return new MySQLBinlogStatement(((StringLiteralValue) visit(ctx.stringLiterals())).getValue());
    }

    @Override
    public ASTNode visitFromTable(final FromTableContext ctx) {
        FromTableSegment result = new FromTableSegment();
        result.setTable((SimpleTableSegment) visit(ctx.tableName()));
        return result;
    }

    @Override
    public ASTNode visitShowVariables(final ShowVariablesContext ctx) {
        MySQLShowVariablesStatement result = new MySQLShowVariablesStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowCharacterSet(final ShowCharacterSetContext ctx) {
        MySQLShowCharacterSetStatement result = new MySQLShowCharacterSetStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowCollation(final ShowCollationContext ctx) {
        MySQLShowCollationStatement result = new MySQLShowCollationStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowFunctionStatus(final ShowFunctionStatusContext ctx) {
        MySQLShowFunctionStatusStatement result = new MySQLShowFunctionStatusStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowProcedureStatus(final ShowProcedureStatusContext ctx) {
        MySQLShowProcedureStatusStatement result = new MySQLShowProcedureStatusStatement();
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowOpenTables(final ShowOpenTablesContext ctx) {
        MySQLShowOpenTablesStatement result = new MySQLShowOpenTablesStatement();
        if (null != ctx.fromSchema()) {
            result.setFromSchema((FromSchemaSegment) visit(ctx.fromSchema()));
        }
        if (null != ctx.showFilter()) {
            result.setFilter((ShowFilterSegment) visit(ctx.showFilter()));
        }
        result.getParameterMarkerSegments().addAll(getParameterMarkerSegments());
        return result;
    }

    @Override
    public ASTNode visitShowPlugins(final ShowPluginsContext ctx) {
        return new MySQLShowPluginsStatement();
    }

    @Override
    public ASTNode visitShowPrivileges(final ShowPrivilegesContext ctx) {
        return new MySQLShowPrivilegesStatement();
    }

    @Override
    public ASTNode visitShutdown(final ShutdownContext ctx) {
        return new MySQLShutdownStatement();
    }

    @Override
    public ASTNode visitShowProcesslist(final ShowProcesslistContext ctx) {
        return new MySQLShowProcessListStatement();
    }

    @Override
    public ASTNode visitShowCreateUser(final ShowCreateUserContext ctx) {
        MySQLShowCreateUserStatement result = new MySQLShowCreateUserStatement();
        result.setName(((IdentifierValue) visit(ctx.username())).getValue());
        return result;
    }

    @Override
    public ASTNode visitSetVariable(final SetVariableContext ctx) {
        MySQLSetStatement result = new MySQLSetStatement();
        Collection<VariableAssignSegment> variableAssigns = getVariableAssigns(ctx.optionValueList());
        result.getVariableAssigns().addAll(variableAssigns);
        return result;
    }

    private Collection<VariableAssignSegment> getVariableAssigns(final OptionValueListContext ctx) {
        Collection<VariableAssignSegment> result = new LinkedList<>();
        if (null == ctx.optionValueNoOptionType()) {
            VariableAssignSegment variableAssign = new VariableAssignSegment();
            variableAssign.setStartIndex(ctx.start.getStartIndex());
            variableAssign.setStopIndex(ctx.setExprOrDefault().stop.getStopIndex());
            VariableSegment variable = new VariableSegment(ctx.internalVariableName().start.getStartIndex(), ctx.internalVariableName().stop.getStopIndex(), ctx.internalVariableName().getText());
            variable.setScope(ctx.optionType().getText());
            variableAssign.setVariable(variable);
            variableAssign.setAssignValue(ctx.setExprOrDefault().getText());
            result.add(variableAssign);
        } else {
            result.add(getVariableAssign(ctx.optionValueNoOptionType()));
        }
        for (OptionValueContext each : ctx.optionValue()) {
            result.add(getVariableAssign(each));
        }
        return result;
    }

    private VariableAssignSegment getVariableAssign(final OptionValueNoOptionTypeContext ctx) {
        VariableAssignSegment result = new VariableAssignSegment();
        result.setStartIndex(ctx.start.getStartIndex());
        result.setStopIndex(ctx.stop.getStopIndex());
        if (null != ctx.NAMES()) {
            // TODO Consider setting all three system variables: character_set_client, character_set_results, character_set_connection
            result.setVariable(new VariableSegment(ctx.NAMES().getSymbol().getStartIndex(), ctx.NAMES().getSymbol().getStopIndex(), "character_set_client"));
            result.setAssignValue(ctx.charsetName().getText());
        } else if (null != ctx.internalVariableName()) {
            result.setVariable(new VariableSegment(ctx.internalVariableName().start.getStartIndex(), ctx.internalVariableName().stop.getStopIndex(), ctx.internalVariableName().getText()));
            result.setAssignValue(ctx.setExprOrDefault().getText());
        } else if (null != ctx.userVariable()) {
            result.setVariable(new VariableSegment(ctx.userVariable().start.getStartIndex(), ctx.userVariable().stop.getStopIndex(), ctx.userVariable().getText()));
            result.setAssignValue(ctx.expr().getText());
        } else if (null != ctx.setSystemVariable()) {
            VariableSegment variable = new VariableSegment(
                    ctx.setSystemVariable().start.getStartIndex(), ctx.setSystemVariable().stop.getStopIndex(), ctx.setSystemVariable().internalVariableName().getText());
            result.setVariable(variable);
            result.setAssignValue(ctx.setExprOrDefault().getText());
            OptionTypeContext optionType = ctx.setSystemVariable().optionType();
            variable.setScope(null != optionType ? optionType.getText() : "SESSION");
        }
        return result;
    }

    private VariableAssignSegment getVariableAssign(final OptionValueContext ctx) {
        if (null != ctx.optionValueNoOptionType()) {
            return getVariableAssign(ctx.optionValueNoOptionType());
        }
        VariableAssignSegment result = new VariableAssignSegment();
        result.setStartIndex(ctx.start.getStartIndex());
        result.setStopIndex(ctx.stop.getStopIndex());
        VariableSegment variable = new VariableSegment(ctx.internalVariableName().start.getStartIndex(), ctx.internalVariableName().stop.getStopIndex(), ctx.internalVariableName().getText());
        variable.setScope(ctx.optionType().getText());
        result.setVariable(variable);
        result.setAssignValue(ctx.setExprOrDefault().getText());
        return result;
    }

    @Override
    public ASTNode visitSetCharacter(final SetCharacterContext ctx) {
        VariableAssignSegment characterSet = new VariableAssignSegment();
        int startIndex = null != ctx.CHARSET() ? ctx.CHARSET().getSymbol().getStartIndex() : ctx.CHARACTER().getSymbol().getStartIndex();
        int stopIndex = null != ctx.CHARSET() ? ctx.CHARSET().getSymbol().getStopIndex() : ctx.SET(1).getSymbol().getStopIndex();
        // TODO Consider setting all three system variables: character_set_client, character_set_results, character_set_connection
        String variableName = (null != ctx.CHARSET()) ? ctx.CHARSET().getText() : "character_set_client";
        VariableSegment variable = new VariableSegment(startIndex, stopIndex, variableName);
        characterSet.setVariable(variable);
        String assignValue = (null != ctx.DEFAULT()) ? ctx.DEFAULT().getText() : ctx.charsetName().getText();
        characterSet.setAssignValue(assignValue);
        MySQLSetStatement result = new MySQLSetStatement();
        result.getVariableAssigns().add(characterSet);
        return result;
    }

    @Override
    public ASTNode visitFromSchema(final FromSchemaContext ctx) {
        return new FromSchemaSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), (DatabaseSegment) visit(ctx.schemaName()));
    }

    @Override
    public ASTNode visitShowLike(final ShowLikeContext ctx) {
        StringLiteralValue literalValue = (StringLiteralValue) visit(ctx.stringLiterals());
        return new ShowLikeSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), literalValue.getValue());
    }

    @Override
    public ASTNode visitCreateLoadableFunction(final CreateLoadableFunctionContext ctx) {
        return new MySQLCreateLoadableFunctionStatement();
    }

    @Override
    public ASTNode visitInstallComponent(final InstallComponentContext ctx) {
        MySQLInstallComponentStatement result = new MySQLInstallComponentStatement();
        List<String> components = new LinkedList<>();
        for (ComponentNameContext each : ctx.componentName()) {
            components.add(((StringLiteralValue) visit(each.string_())).getValue());
        }
        result.getComponents().addAll(components);
        return result;
    }

    @Override
    public ASTNode visitUninstallComponent(final UninstallComponentContext ctx) {
        MySQLUninstallComponentStatement result = new MySQLUninstallComponentStatement();
        List<String> components = new LinkedList<>();
        for (ComponentNameContext each : ctx.componentName()) {
            components.add(((StringLiteralValue) visit(each.string_())).getValue());
        }
        result.getComponents().addAll(components);
        return result;
    }

    @Override
    public ASTNode visitRestart(final RestartContext ctx) {
        return new MySQLRestartStatement();
    }

    @Override
    public ASTNode visitSetResourceGroup(final SetResourceGroupContext ctx) {
        MySQLSetResourceGroupStatement result = new MySQLSetResourceGroupStatement();
        result.setGroupName(((IdentifierValue) visit(ctx.groupName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitCheckTable(final CheckTableContext ctx) {
        MySQLCheckTableStatement result = new MySQLCheckTableStatement();
        result.getTables().addAll(((CollectionValue<SimpleTableSegment>) visit(ctx.tableList())).getValue());
        return result;
    }

    @Override
    public ASTNode visitDropResourceGroup(final DropResourceGroupContext ctx) {
        MySQLDropResourceGroupStatement result = new MySQLDropResourceGroupStatement();
        result.setGroupName(((IdentifierValue) visit(ctx.groupName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitAlterResourceGroup(final AlterResourceGroupContext ctx) {
        MySQLAlterResourceGroupStatement result = new MySQLAlterResourceGroupStatement();
        result.setGroupName(((IdentifierValue) visit(ctx.groupName())).getValue());
        return result;
    }

    @Override
    public ASTNode visitDelimiter(final DelimiterContext ctx) {
        MySQLDelimiterStatement result = new MySQLDelimiterStatement();
        result.setDelimiterName(ctx.delimiterName().getText());
        return result;
    }

    @Override
    public ASTNode visitHelp(final HelpContext ctx) {
        MySQLHelpStatement result = new MySQLHelpStatement();
        result.setSearchString(ctx.textOrIdentifier().getText());
        return result;
    }
}
