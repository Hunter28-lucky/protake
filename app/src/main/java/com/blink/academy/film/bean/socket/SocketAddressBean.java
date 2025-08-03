package com.blink.academy.film.bean.socket;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SocketAddressBean implements Serializable {
    private boolean isConnected = false;
    private String socketIp;
    private SocketMessage socketMessage;
    private int socketPort;

    public String toString() {
        return "SocketAddressBean{socketMessage=" + this.socketMessage.toString() + ", socketIp='" + this.socketIp + "', isConnected='" + this.isConnected + "'}";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public SocketMessage m488() {
        return this.socketMessage;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m489() {
        return this.socketPort;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m490() {
        return this.isConnected;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m491(String str) {
        this.socketIp = str;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m492(SocketMessage socketMessage) {
        this.socketMessage = socketMessage;
    }
}
