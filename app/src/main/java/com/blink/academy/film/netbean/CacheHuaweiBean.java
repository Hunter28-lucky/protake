package com.blink.academy.film.netbean;

/* loaded from: classes.dex */
public class CacheHuaweiBean {
    private String InAppSignature;
    private String inAppPurchaseData;
    private String subsId;
    private int subscription_expire_time;
    private boolean subscription_is_valid;

    public String getInAppPurchaseData() {
        return this.inAppPurchaseData;
    }

    public String getInAppSignature() {
        return this.InAppSignature;
    }

    public String getSubsId() {
        return this.subsId;
    }

    public int getSubscription_expire_time() {
        return this.subscription_expire_time;
    }

    public boolean isSubscription_is_valid() {
        return this.subscription_is_valid;
    }

    public CacheHuaweiBean setInAppPurchaseData(String str) {
        this.inAppPurchaseData = str;
        return this;
    }

    public CacheHuaweiBean setInAppSignature(String str) {
        this.InAppSignature = str;
        return this;
    }

    public CacheHuaweiBean setSubsId(String str) {
        this.subsId = str;
        return this;
    }

    public CacheHuaweiBean setSubscription_expire_time(int i) {
        this.subscription_expire_time = i;
        return this;
    }

    public CacheHuaweiBean setSubscription_is_valid(boolean z) {
        this.subscription_is_valid = z;
        return this;
    }
}
