package com.glodon.translator.parser.dialect.mysql.statement.dal;

import com.glodon.translator.parser.dialect.mysql.statement.MySQLStatement;
import com.glodon.translator.parser.dialect.mysql.statement.segment.CacheTableIndexSegment;
import com.glodon.translator.parser.dialect.mysql.statement.segment.PartitionDefinitionSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.dal.DALStatement;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Collection;
import java.util.LinkedList;

public final class MySQLCacheIndexStatement extends AbstractSQLStatement implements DALStatement, MySQLStatement {

    private final Collection<CacheTableIndexSegment> tableIndexes = new LinkedList<>();

    private PartitionDefinitionSegment partitionDefinition;

    private IdentifierValue name;

    public Collection<CacheTableIndexSegment> getTableIndexes() {
        return tableIndexes;
    }

    public PartitionDefinitionSegment getPartitionDefinition() {
        return partitionDefinition;
    }

    public void setPartitionDefinition(PartitionDefinitionSegment partitionDefinition) {
        this.partitionDefinition = partitionDefinition;
    }

    public IdentifierValue getName() {
        return name;
    }

    public void setName(IdentifierValue name) {
        this.name = name;
    }
}
