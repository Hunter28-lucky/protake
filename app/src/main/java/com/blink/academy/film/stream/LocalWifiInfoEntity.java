package com.blink.academy.film.stream;

/* loaded from: classes.dex */
public class LocalWifiInfoEntity {
    private String bssid;
    private String deviceName;
    private String ip;
    private int rssi;
    private String ssid;

    public String getBssid() {
        return this.bssid;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getIp() {
        return this.ip;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSsid() {
        return this.ssid;
    }

    public LocalWifiInfoEntity setBssid(String str) {
        this.bssid = str;
        return this;
    }

    public LocalWifiInfoEntity setDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public LocalWifiInfoEntity setIp(String str) {
        this.ip = str;
        return this;
    }

    public LocalWifiInfoEntity setRssi(int i) {
        this.rssi = i;
        return this;
    }

    public LocalWifiInfoEntity setSsid(String str) {
        this.ssid = str;
        return this;
    }
}
