package com.blink.academy.film.support.pay.huawei;

import java.util.List;

/* loaded from: classes.dex */
public class UploadHuaweiBean {
    private String OSVersion;
    private String a_sha;
    private String access_token;
    private String app_build;
    private String app_version;
    private String current_user_id;
    private String device_manufacturer;
    private String device_model;
    private List<HuaweiPurchaseBean> hms_purchases;
    private String platform_locale;
    private String platform_type;
    private String platform_version;
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

    public String getCurrent_user_id() {
        return this.current_user_id;
    }

    public String getDevice_manufacturer() {
        return this.device_manufacturer;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public List<HuaweiPurchaseBean> getHms_purchases() {
        return this.hms_purchases;
    }

    public String getOSVersion() {
        return this.OSVersion;
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

    public String getUuid() {
        return this.uuid;
    }

    public UploadHuaweiBean setA_sha(String str) {
        this.a_sha = str;
        return this;
    }

    public UploadHuaweiBean setAccess_token(String str) {
        this.access_token = str;
        return this;
    }

    public UploadHuaweiBean setApp_build(String str) {
        this.app_build = str;
        return this;
    }

    public UploadHuaweiBean setApp_version(String str) {
        this.app_version = str;
        return this;
    }

    public UploadHuaweiBean setCurrent_user_id(String str) {
        this.current_user_id = str;
        return this;
    }

    public UploadHuaweiBean setDevice_manufacturer(String str) {
        this.device_manufacturer = str;
        return this;
    }

    public UploadHuaweiBean setDevice_model(String str) {
        this.device_model = str;
        return this;
    }

    public UploadHuaweiBean setHms_purchases(List<HuaweiPurchaseBean> list) {
        this.hms_purchases = list;
        return this;
    }

    public UploadHuaweiBean setOSVersion(String str) {
        this.OSVersion = str;
        return this;
    }

    public UploadHuaweiBean setPlatform_locale(String str) {
        this.platform_locale = str;
        return this;
    }

    public UploadHuaweiBean setPlatform_type(String str) {
        this.platform_type = str;
        return this;
    }

    public UploadHuaweiBean setPlatform_version(String str) {
        this.platform_version = str;
        return this;
    }

    public UploadHuaweiBean setUuid(String str) {
        this.uuid = str;
        return this;
    }
}
