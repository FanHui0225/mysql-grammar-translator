
package com.glodon.translator.parser.segment.dml.column;

import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.generic.OwnerAvailable;
import com.glodon.translator.parser.segment.generic.OwnerSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

import java.util.Optional;

public final class ColumnSegment implements ExpressionSegment, OwnerAvailable {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue identifier;

    private OwnerSegment owner;

    public ColumnSegment(int startIndex, int stopIndex, IdentifierValue identifier) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
    }

    public ColumnSegment(int startIndex, int stopIndex, IdentifierValue identifier, OwnerSegment owner) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.identifier = identifier;
        this.owner = owner;
    }

    public String getQualifiedName() {
        return null == owner ? identifier.getValueWithQuoteCharacters() : String.join(".", owner.getIdentifier().getValueWithQuoteCharacters(), identifier.getValueWithQuoteCharacters());
    }

    public String getExpression() {
        return null == owner ? identifier.getValue() : String.join(".", owner.getIdentifier().getValue(), identifier.getValue());
    }

    @Override
    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public IdentifierValue getIdentifier() {
        return identifier;
    }

    @Override
    public void setOwner(OwnerSegment owner) {
        this.owner = owner;
    }
}
