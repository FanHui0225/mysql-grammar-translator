package com.glodon.translator.parser.segment.dml.pagination;

import com.glodon.translator.parser.segment.SQLSegment;

public interface PaginationValueSegment extends SQLSegment {

    boolean isBoundOpened();
}
