package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class VerifyResultBean {
    private String channel;
    private boolean isParseError;
    private boolean isValidNumber;
    private String model;
    private String nationalNumber;

    public String getChannel() {
        return this.channel;
    }

    public String getModel() {
        return this.model;
    }

    public String getNationalNumber() {
        return this.nationalNumber;
    }

    public boolean isParseError() {
        return this.isParseError;
    }

    public boolean isValidNumber() {
        return this.isValidNumber;
    }

    public VerifyResultBean setChannel(String str) {
        this.channel = str;
        return this;
    }

    public VerifyResultBean setModel(String str) {
        this.model = str;
        return this;
    }

    public void setNationalNumber(String str) {
        this.nationalNumber = str;
    }

    public void setParseError(boolean z) {
        this.isParseError = z;
    }

    public void setValidNumber(boolean z) {
        this.isValidNumber = z;
    }
}
