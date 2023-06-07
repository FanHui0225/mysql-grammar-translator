package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Optional;

public interface AliasAvailable extends SQLSegment {

    Optional<String> getAliasName();

    Optional<AliasSegment> getAlias();

    void setAlias(AliasSegment alias);
}
