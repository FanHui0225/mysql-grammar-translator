package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

import java.util.Optional;

public interface OwnerAvailable extends SQLSegment {

    Optional<OwnerSegment> getOwner();

    void setOwner(OwnerSegment owner);
}
