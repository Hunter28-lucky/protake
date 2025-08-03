package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class UserInfoBean {
    private String client_nonce;
    private int subscription_expire_time;
    private boolean subscription_is_valid;
    private int uid;
    private boolean user_is_logged_in;
    private String user_phone_number_desensitized;
    private String user_phone_zone;
    private int user_status;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public int getSubscription_expire_time() {
        return this.subscription_expire_time;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUser_phone_number_desensitized() {
        return this.user_phone_number_desensitized;
    }

    public String getUser_phone_zone() {
        return this.user_phone_zone;
    }

    public int getUser_status() {
        return this.user_status;
    }

    public boolean isSubscription_is_valid() {
        return this.subscription_is_valid;
    }

    public boolean isUser_is_logged_in() {
        return this.user_is_logged_in;
    }

    public UserInfoBean setClient_nonce(String str) {
        this.client_nonce = str;
        return this;
    }

    public UserInfoBean setSubscription_expire_time(int i) {
        this.subscription_expire_time = i;
        return this;
    }

    public UserInfoBean setSubscription_is_valid(boolean z) {
        this.subscription_is_valid = z;
        return this;
    }

    public UserInfoBean setUid(int i) {
        this.uid = i;
        return this;
    }

    public UserInfoBean setUser_is_logged_in(boolean z) {
        this.user_is_logged_in = z;
        return this;
    }

    public UserInfoBean setUser_phone_number_desensitized(String str) {
        this.user_phone_number_desensitized = str;
        return this;
    }

    public UserInfoBean setUser_phone_zone(String str) {
        this.user_phone_zone = str;
        return this;
    }

    public UserInfoBean setUser_status(int i) {
        this.user_status = i;
        return this;
    }
}
