package com.blink.academy.film.stream;

/* loaded from: classes.dex */
public class NetInfoBean {
    public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    public static final String UNKNOWN_SSID = "<unknown ssid>";
    private String bssid;
    private String gatewayIP;
    private String localIP;
    private String localName;
    private String ssid;
    private int wifiLevel;
    private int wifiStatus;

    public String getBssid() {
        return this.bssid;
    }

    public String getGatewayIP() {
        return this.gatewayIP;
    }

    public String getLocalIP() {
        return this.localIP;
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getSsid() {
        return this.ssid;
    }

    public int getWifiLevel() {
        return this.wifiLevel;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setGatewayIP(String str) {
        this.gatewayIP = str;
    }

    public void setLocalIP(String str) {
        this.localIP = str;
    }

    public void setLocalName(String str) {
        this.localName = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setWifiLevel(int i) {
        this.wifiLevel = i;
    }

    public void setWifiStatus(int i) {
        this.wifiStatus = i;
    }
}
