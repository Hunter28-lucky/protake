package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class UserMobileBean {
    private long uid;
    private String user_phone_number;
    private String user_phone_zone;

    public long getUid() {
        return this.uid;
    }

    public String getUser_phone_number() {
        return this.user_phone_number;
    }

    public String getUser_phone_zone() {
        return this.user_phone_zone;
    }

    public UserMobileBean setUid(long j) {
        this.uid = j;
        return this;
    }

    public UserMobileBean setUser_phone_number(String str) {
        this.user_phone_number = str;
        return this;
    }

    public UserMobileBean setUser_phone_zone(String str) {
        this.user_phone_zone = str;
        return this;
    }
}
