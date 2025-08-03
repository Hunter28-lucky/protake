package com.blink.academy.film.bean.socket;

import defpackage.C5070;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SocketMessage implements Serializable {
    private int controlState;
    private long createTime;
    private String deviceContent;
    private long expTime;
    private String host;
    private C5070 info;
    private boolean isBanned;
    private int mode;
    private String msg;
    private String name;
    private long receiveTime;
    private int wifiState;

    public String toString() {
        return "SocketMessage{host='" + this.host + "', name='" + this.name + "', mode=" + this.mode + ", createTime=" + this.createTime + ", msg='" + this.msg + "', expTime=" + this.expTime + ", receiveTime=" + this.receiveTime + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long m493() {
        return this.createTime;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m494() {
        return this.host;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m495() {
        return this.mode;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m496() {
        return this.name;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m497(long j) {
        this.createTime = j;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m498(String str) {
        this.host = str;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m499(int i) {
        this.mode = i;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m500(String str) {
        this.msg = str;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m501(String str) {
        this.name = str;
    }
}
