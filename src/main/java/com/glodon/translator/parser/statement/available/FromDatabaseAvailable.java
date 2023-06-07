package com.glodon.translator.parser.statement.available;

import com.glodon.translator.parser.segment.generic.DatabaseSegment;

import java.util.Optional;

public interface FromDatabaseAvailable {

    Optional<DatabaseSegment> getDatabase();
}
