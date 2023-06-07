package com.glodon.translator.parser.segment.generic.table;

import com.glodon.translator.parser.segment.generic.AliasSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;

import java.util.Optional;

public final class SimpleTableSegment implements TableSegment, OwnerAvailable {

    private final TableNameSegment tableName;

    private OwnerSegment owner;

    @Override
    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }

    private AliasSegment alias;

    @Override
    public void setAlias(AliasSegment alias) {
        this.alias = alias;
    }

    public SimpleTableSegment(TableNameSegment tableName) {
        this.tableName = tableName;
    }

    public SimpleTableSegment(TableNameSegment tableName, OwnerSegment owner, AliasSegment alias) {
        this.tableName = tableName;
        this.owner = owner;
        this.alias = alias;
    }

    @Override
    public int getStartIndex() {
        if (null == owner) {
            return tableName.getStartIndex();
        }
        return owner.getOwner().isPresent() ? owner.getOwner().get().getStartIndex() : owner.getStartIndex();
    }

    @Override
    public int getStopIndex() {
        return null == alias ? tableName.getStopIndex() : alias.getStopIndex();
    }

    @Override
    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
    }

    @Override
    public Optional<String> getAliasName() {
        return null == alias ? Optional.empty() : Optional.ofNullable(alias.getIdentifier().getValue());
    }

    @Override
    public Optional<AliasSegment> getAlias() {
        return Optional.ofNullable(alias);
    }
}
