
package com.glodon.translator.parser.segment.generic;

import com.glodon.translator.parser.segment.SQLSegment;

public interface ParameterMarkerSegment extends SQLSegment {

    int getParameterIndex();
}
