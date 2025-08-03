// TODO: REMOVE - This class is obsolete and only used for Google Play Billing verification.
// Safe to delete after confirming no references remain.
package com.blink.academy.film.support.pay.google;

/* loaded from: classes.dex */
public class VerifyBillingBean {
    private String a_sha;
    private String access_token;
    private String app_build;
    private String app_version;
    private int current_user_id;
    private String device_manufacturer;
    private String device_model;
    private String platform_locale;
    private String platform_type;
    private String platform_version;
    private String signature;
    private String signedData;
    private String uuid;

    public String getA_sha() {
        return this.a_sha;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public String getApp_build() {
        return this.app_build;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public int getCurrent_user_id() {
        return this.current_user_id;
    }

    public String getDevice_manufacturer() {
        return this.device_manufacturer;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public String getPlatform_locale() {
        return this.platform_locale;
    }

    public String getPlatform_type() {
        return this.platform_type;
    }

    public String getPlatform_version() {
        return this.platform_version;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSignedData() {
        return this.signedData;
    }

    public String getUuid() {
        return this.uuid;
    }

    public VerifyBillingBean setA_sha(String str) {
        this.a_sha = str;
        return this;
    }

    public VerifyBillingBean setAccess_token(String str) {
        this.access_token = str;
        return this;
    }

    public VerifyBillingBean setApp_build(String str) {
        this.app_build = str;
        return this;
    }

    public VerifyBillingBean setApp_version(String str) {
        this.app_version = str;
        return this;
    }

    public VerifyBillingBean setCurrent_user_id(int i) {
        this.current_user_id = i;
        return this;
    }

    public VerifyBillingBean setDevice_manufacturer(String str) {
        this.device_manufacturer = str;
        return this;
    }

    public VerifyBillingBean setDevice_model(String str) {
        this.device_model = str;
        return this;
    }

    public VerifyBillingBean setPlatform_locale(String str) {
        this.platform_locale = str;
        return this;
    }

    public VerifyBillingBean setPlatform_type(String str) {
        this.platform_type = str;
        return this;
    }

    public VerifyBillingBean setPlatform_version(String str) {
        this.platform_version = str;
        return this;
    }

    public VerifyBillingBean setSignature(String str) {
        this.signature = str;
        return this;
    }

    public VerifyBillingBean setSignedData(String str) {
        this.signedData = str;
        return this;
    }

    public VerifyBillingBean setUuid(String str) {
        this.uuid = str;
        return this;
    }
}
