package com.blink.academy.film.netbean.store;

import defpackage.r1;

/* loaded from: classes.dex */
public class SubscribeInfoCallback {
    private String client_nonce;
    private String info;
    private String sub_gplay_id;
    private String sub_hms_id;
    private String subscription_price_cny;
    private String subscription_price_cny_origin;
    private String subscription_price_usd;
    private String subscription_price_usd_origin;
    private String subscription_product_google_id;
    private String subscription_product_id;

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public String getInfo() {
        return this.info;
    }

    public String getShow_Subscription_price_cny() {
        return this.subscription_price_cny;
    }

    public String getShow_Subscription_price_cny_Origin() {
        return this.subscription_price_cny_origin;
    }

    public String getShow_Subscription_price_usd() {
        return this.subscription_price_usd;
    }

    public String getShow_Subscription_price_usd_Origin() {
        return this.subscription_price_usd_origin;
    }

    public String getSub_gplay_id() {
        return this.sub_gplay_id;
    }

    public String getSub_hms_id() {
        return this.sub_hms_id;
    }

    public float getSubscription_price_cny() {
        if (r1.m8143(this.subscription_price_cny)) {
            return Float.parseFloat(this.subscription_price_cny);
        }
        return 0.0f;
    }

    public float getSubscription_price_cny_origin() {
        if (r1.m8143(this.subscription_price_cny_origin)) {
            return Float.parseFloat(this.subscription_price_cny_origin);
        }
        return 0.0f;
    }

    public float getSubscription_price_usd() {
        if (r1.m8143(this.subscription_price_usd)) {
            return Float.parseFloat(this.subscription_price_usd);
        }
        return 0.0f;
    }

    public float getSubscription_price_usd_origin() {
        if (r1.m8143(this.subscription_price_usd_origin)) {
            return Float.parseFloat(this.subscription_price_usd_origin);
        }
        return 0.0f;
    }

    public String getSubscription_product_google_id() {
        return this.subscription_product_google_id;
    }

    public String getSubscription_product_id() {
        return this.subscription_product_id;
    }

    public SubscribeInfoCallback setClient_nonce(String str) {
        this.client_nonce = str;
        return this;
    }

    public SubscribeInfoCallback setInfo(String str) {
        this.info = str;
        return this;
    }

    public SubscribeInfoCallback setSub_gplay_id(String str) {
        this.sub_gplay_id = str;
        return this;
    }

    public SubscribeInfoCallback setSub_hms_id(String str) {
        this.sub_hms_id = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_price_cny(String str) {
        this.subscription_price_cny = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_price_cny_origin(String str) {
        this.subscription_price_cny_origin = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_price_usd(String str) {
        this.subscription_price_usd = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_price_usd_origin(String str) {
        this.subscription_price_usd_origin = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_product_google_id(String str) {
        this.subscription_product_google_id = str;
        return this;
    }

    public SubscribeInfoCallback setSubscription_product_id(String str) {
        this.subscription_product_id = str;
        return this;
    }
}
