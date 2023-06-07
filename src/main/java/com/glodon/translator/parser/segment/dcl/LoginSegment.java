
package com.glodon.translator.parser.segment.dcl;

import com.glodon.translator.parser.segment.SQLSegment;
import com.glodon.translator.parser.value.identifier.IdentifierValue;

public final class LoginSegment implements SQLSegment {

    private final int startIndex;

    private final int stopIndex;

    private final IdentifierValue loginName;

    public LoginSegment(int startIndex, int stopIndex, IdentifierValue loginName) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.loginName = loginName;
    }

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public IdentifierValue getLoginName() {
        return loginName;
    }
}
