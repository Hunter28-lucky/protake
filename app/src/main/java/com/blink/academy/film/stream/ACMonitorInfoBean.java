package com.blink.academy.film.stream;

/* loaded from: classes.dex */
public class ACMonitorInfoBean {
    private String captureEvent;
    private boolean init;
    private String job;
    private String netType;
    private String suffix;
    private String uuid;
    private int wifiStatus;

    public String getCaptureEvent() {
        return this.captureEvent;
    }

    public String getJob() {
        return this.job;
    }

    public String getNetType() {
        return this.netType;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public boolean isInit() {
        return this.init;
    }

    public void setCaptureEvent(String str) {
        this.captureEvent = str;
    }

    public void setInit(boolean z) {
        this.init = z;
    }

    public void setJob(String str) {
        this.job = str;
    }

    public void setNetType(String str) {
        this.netType = str;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setWifiStatus(int i) {
        this.wifiStatus = i;
    }
}
