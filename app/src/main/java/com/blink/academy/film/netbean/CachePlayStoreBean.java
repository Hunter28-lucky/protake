package com.blink.academy.film.netbean;

import com.android.billingclient.api.Purchase;

/* loaded from: classes.dex */
public class CachePlayStoreBean {
    private Purchase purchase;
    private String subsId;
    private int subscription_expire_time;
    private boolean subscription_is_valid;

    public Purchase getPurchase() {
        return this.purchase;
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

    public CachePlayStoreBean setPurchase(Purchase purchase) {
        this.purchase = purchase;
        return this;
    }

    public CachePlayStoreBean setSubsId(String str) {
        this.subsId = str;
        return this;
    }

    public CachePlayStoreBean setSubscription_expire_time(int i) {
        this.subscription_expire_time = i;
        return this;
    }

    public CachePlayStoreBean setSubscription_is_valid(boolean z) {
        this.subscription_is_valid = z;
        return this;
    }
}
