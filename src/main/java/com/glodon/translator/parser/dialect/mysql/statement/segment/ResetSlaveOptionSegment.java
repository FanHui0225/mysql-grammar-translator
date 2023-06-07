package com.glodon.translator.parser.dialect.mysql.statement.segment;

public final class ResetSlaveOptionSegment extends ResetOptionSegment {

    private boolean all;

    private String channelOption;

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public String getChannelOption() {
        return channelOption;
    }

    public void setChannelOption(String channelOption) {
        this.channelOption = channelOption;
    }
}
