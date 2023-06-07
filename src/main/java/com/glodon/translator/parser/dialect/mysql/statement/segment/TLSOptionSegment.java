package com.glodon.translator.parser.dialect.mysql.statement.segment;

import com.glodon.translator.parser.segment.SQLSegment;

public final class TLSOptionSegment implements SQLSegment {

    private int startIndex;

    private int stopIndex;

    private SSLTypeEnum type;

    private String x509Subject;

    private String x509Issuer;

    private String x509Cipher;

    public TLSOptionSegment() {
    }

    public TLSOptionSegment(int startIndex, int stopIndex, SSLTypeEnum type, String x509Subject, String x509Issuer, String x509Cipher) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.type = type;
        this.x509Subject = x509Subject;
        this.x509Issuer = x509Issuer;
        this.x509Cipher = x509Cipher;
    }

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

    public SSLTypeEnum getType() {
        return type;
    }

    public void setType(SSLTypeEnum type) {
        this.type = type;
    }

    public String getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(String x509Subject) {
        this.x509Subject = x509Subject;
    }

    public String getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(String x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public String getX509Cipher() {
        return x509Cipher;
    }

    public void setX509Cipher(String x509Cipher) {
        this.x509Cipher = x509Cipher;
    }
}
