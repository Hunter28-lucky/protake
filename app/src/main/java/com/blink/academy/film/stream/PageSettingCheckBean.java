package com.blink.academy.film.stream;

/* loaded from: classes.dex */
public class PageSettingCheckBean {
    private boolean ban;
    private int controlState;
    private String message;
    private int wifiLevel;

    public int getControlState() {
        return this.controlState;
    }

    public String getMessage() {
        return this.message;
    }

    public int getWifiLevel() {
        return this.wifiLevel;
    }

    public boolean isBan() {
        return this.ban;
    }

    public void setBan(boolean z) {
        this.ban = z;
    }

    public void setControlState(int i) {
        this.controlState = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setWifiLevel(int i) {
        this.wifiLevel = i;
    }
}
