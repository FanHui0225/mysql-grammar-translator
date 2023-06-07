package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class PasswordOrLockOptionSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private boolean updatePasswordExpiredFields;

    private boolean updatePasswordExpiredColumn;

    private boolean useDefaultPasswordLifeTime;

    private int expireAfterDays;

    private boolean updateAccountLockedColumn;

    private boolean accountLocked;

    private int passwordHistoryLength;

    private boolean useDefaultPasswordHistory;

    private boolean updatePasswordHistory;

    private int passwordReuseInterval;

    private boolean useDefaultPasswordReuseInterval;

    private boolean updatePasswordReuseInterval;

    private int failedLoginAttempts;

    private boolean updateFailedLoginAttempts;

    private int passwordLockTime;

    private boolean updatePasswordLockTime;

    private ACLAttributeEnum updatePasswordRequireCurrent;

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

    public boolean isUpdatePasswordExpiredFields() {
        return updatePasswordExpiredFields;
    }

    public void setUpdatePasswordExpiredFields(boolean updatePasswordExpiredFields) {
        this.updatePasswordExpiredFields = updatePasswordExpiredFields;
    }

    public boolean isUpdatePasswordExpiredColumn() {
        return updatePasswordExpiredColumn;
    }

    public void setUpdatePasswordExpiredColumn(boolean updatePasswordExpiredColumn) {
        this.updatePasswordExpiredColumn = updatePasswordExpiredColumn;
    }

    public boolean isUseDefaultPasswordLifeTime() {
        return useDefaultPasswordLifeTime;
    }

    public void setUseDefaultPasswordLifeTime(boolean useDefaultPasswordLifeTime) {
        this.useDefaultPasswordLifeTime = useDefaultPasswordLifeTime;
    }

    public int getExpireAfterDays() {
        return expireAfterDays;
    }

    public void setExpireAfterDays(int expireAfterDays) {
        this.expireAfterDays = expireAfterDays;
    }

    public boolean isUpdateAccountLockedColumn() {
        return updateAccountLockedColumn;
    }

    public void setUpdateAccountLockedColumn(boolean updateAccountLockedColumn) {
        this.updateAccountLockedColumn = updateAccountLockedColumn;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public int getPasswordHistoryLength() {
        return passwordHistoryLength;
    }

    public void setPasswordHistoryLength(int passwordHistoryLength) {
        this.passwordHistoryLength = passwordHistoryLength;
    }

    public boolean isUseDefaultPasswordHistory() {
        return useDefaultPasswordHistory;
    }

    public void setUseDefaultPasswordHistory(boolean useDefaultPasswordHistory) {
        this.useDefaultPasswordHistory = useDefaultPasswordHistory;
    }

    public boolean isUpdatePasswordHistory() {
        return updatePasswordHistory;
    }

    public void setUpdatePasswordHistory(boolean updatePasswordHistory) {
        this.updatePasswordHistory = updatePasswordHistory;
    }

    public int getPasswordReuseInterval() {
        return passwordReuseInterval;
    }

    public void setPasswordReuseInterval(int passwordReuseInterval) {
        this.passwordReuseInterval = passwordReuseInterval;
    }

    public boolean isUseDefaultPasswordReuseInterval() {
        return useDefaultPasswordReuseInterval;
    }

    public void setUseDefaultPasswordReuseInterval(boolean useDefaultPasswordReuseInterval) {
        this.useDefaultPasswordReuseInterval = useDefaultPasswordReuseInterval;
    }

    public boolean isUpdatePasswordReuseInterval() {
        return updatePasswordReuseInterval;
    }

    public void setUpdatePasswordReuseInterval(boolean updatePasswordReuseInterval) {
        this.updatePasswordReuseInterval = updatePasswordReuseInterval;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public boolean isUpdateFailedLoginAttempts() {
        return updateFailedLoginAttempts;
    }

    public void setUpdateFailedLoginAttempts(boolean updateFailedLoginAttempts) {
        this.updateFailedLoginAttempts = updateFailedLoginAttempts;
    }

    public int getPasswordLockTime() {
        return passwordLockTime;
    }

    public void setPasswordLockTime(int passwordLockTime) {
        this.passwordLockTime = passwordLockTime;
    }

    public boolean isUpdatePasswordLockTime() {
        return updatePasswordLockTime;
    }

    public void setUpdatePasswordLockTime(boolean updatePasswordLockTime) {
        this.updatePasswordLockTime = updatePasswordLockTime;
    }

    public ACLAttributeEnum getUpdatePasswordRequireCurrent() {
        return updatePasswordRequireCurrent;
    }

    public void setUpdatePasswordRequireCurrent(ACLAttributeEnum updatePasswordRequireCurrent) {
        this.updatePasswordRequireCurrent = updatePasswordRequireCurrent;
    }
}
