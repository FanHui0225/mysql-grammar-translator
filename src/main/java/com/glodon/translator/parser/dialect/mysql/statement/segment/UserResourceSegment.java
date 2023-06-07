package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class UserResourceSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private int questions;

    private int updates;

    private int connPerHour;

    private int userConn;

    private UserResourceSpecifiedLimitEnum specifiedLimits;

    @Override
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public int getUpdates() {
        return updates;
    }

    public void setUpdates(int updates) {
        this.updates = updates;
    }

    public int getConnPerHour() {
        return connPerHour;
    }

    public void setConnPerHour(int connPerHour) {
        this.connPerHour = connPerHour;
    }

    public int getUserConn() {
        return userConn;
    }

    public void setUserConn(int userConn) {
        this.userConn = userConn;
    }

    public UserResourceSpecifiedLimitEnum getSpecifiedLimits() {
        return specifiedLimits;
    }

    public void setSpecifiedLimits(UserResourceSpecifiedLimitEnum specifiedLimits) {
        this.specifiedLimits = specifiedLimits;
    }
}
