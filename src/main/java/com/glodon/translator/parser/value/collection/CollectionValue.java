package com.glodon.translator.parser.value.collection;

import com.glodon.translator.parser.value.ValueASTNode;

import java.util.Collection;
import java.util.LinkedList;

public final class CollectionValue<T> implements ValueASTNode<Collection> {

    private final Collection<T> value = new LinkedList<>();

    public void combine(final CollectionValue<T> collectionValue) {
        value.addAll(collectionValue.value);
    }

    @Override
    public Collection<T> getValue() {
        return value;
    }
}