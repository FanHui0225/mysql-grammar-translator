package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class UserSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private String user;

    private String host;

    private String plugin;

    private String auth;

    private String currentAuth;

    private boolean usesIdentifiedByClause;

    private boolean usesIdentifiedWithClause;

    private boolean usesAuthenticationStringClause;

    private boolean usesReplaceClause;

    private boolean retainCurrentPassword;

    private boolean discardOldPassword;

    private boolean hasPasswordGenerator;

    private PasswordOrLockOptionSegment alterStatus;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getCurrentAuth() {
        return currentAuth;
    }

    public void setCurrentAuth(String currentAuth) {
        this.currentAuth = currentAuth;
    }

    public boolean isUsesIdentifiedByClause() {
        return usesIdentifiedByClause;
    }

    public void setUsesIdentifiedByClause(boolean usesIdentifiedByClause) {
        this.usesIdentifiedByClause = usesIdentifiedByClause;
    }

    public boolean isUsesIdentifiedWithClause() {
        return usesIdentifiedWithClause;
    }

    public void setUsesIdentifiedWithClause(boolean usesIdentifiedWithClause) {
        this.usesIdentifiedWithClause = usesIdentifiedWithClause;
    }

    public boolean isUsesAuthenticationStringClause() {
        return usesAuthenticationStringClause;
    }

    public void setUsesAuthenticationStringClause(boolean usesAuthenticationStringClause) {
        this.usesAuthenticationStringClause = usesAuthenticationStringClause;
    }

    public boolean isUsesReplaceClause() {
        return usesReplaceClause;
    }

    public void setUsesReplaceClause(boolean usesReplaceClause) {
        this.usesReplaceClause = usesReplaceClause;
    }

    public boolean isRetainCurrentPassword() {
        return retainCurrentPassword;
    }

    public void setRetainCurrentPassword(boolean retainCurrentPassword) {
        this.retainCurrentPassword = retainCurrentPassword;
    }

    public boolean isDiscardOldPassword() {
        return discardOldPassword;
    }

    public void setDiscardOldPassword(boolean discardOldPassword) {
        this.discardOldPassword = discardOldPassword;
    }

    public boolean isHasPasswordGenerator() {
        return hasPasswordGenerator;
    }

    public void setHasPasswordGenerator(boolean hasPasswordGenerator) {
        this.hasPasswordGenerator = hasPasswordGenerator;
    }

    public PasswordOrLockOptionSegment getAlterStatus() {
        return alterStatus;
    }

    public void setAlterStatus(PasswordOrLockOptionSegment alterStatus) {
        this.alterStatus = alterStatus;
    }
}
