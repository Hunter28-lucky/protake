package com.blink.academy.film.netbean.store;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppConfigCallbackEntity implements Parcelable {
    public static final Parcelable.Creator<AppConfigCallbackEntity> CREATOR = new C0447();
    private StoreMessageBean app_alert;
    private String client_nonce;
    private PrivacyVersionBean legal;
    private String server_nonce;
    private long timestamp;
    private String wxpay_app_id;

    /* renamed from: com.blink.academy.film.netbean.store.AppConfigCallbackEntity$Ϳ, reason: contains not printable characters */
    public class C0447 implements Parcelable.Creator<AppConfigCallbackEntity> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AppConfigCallbackEntity createFromParcel(Parcel parcel) {
            return new AppConfigCallbackEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AppConfigCallbackEntity[] newArray(int i) {
            return new AppConfigCallbackEntity[i];
        }
    }

    public AppConfigCallbackEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StoreMessageBean getApp_alert() {
        return this.app_alert;
    }

    public String getClient_nonce() {
        return this.client_nonce;
    }

    public PrivacyVersionBean getLegal() {
        return this.legal;
    }

    public String getServer_nonce() {
        return this.server_nonce;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getWxpay_app_id() {
        return this.wxpay_app_id;
    }

    public AppConfigCallbackEntity setApp_alert(StoreMessageBean storeMessageBean) {
        this.app_alert = storeMessageBean;
        return this;
    }

    public AppConfigCallbackEntity setClient_nonce(String str) {
        this.client_nonce = str;
        return this;
    }

    public AppConfigCallbackEntity setLegal(PrivacyVersionBean privacyVersionBean) {
        this.legal = privacyVersionBean;
        return this;
    }

    public AppConfigCallbackEntity setServer_nonce(String str) {
        this.server_nonce = str;
        return this;
    }

    public AppConfigCallbackEntity setTimestamp(long j) {
        this.timestamp = j;
        return this;
    }

    public AppConfigCallbackEntity setWxpay_app_id(String str) {
        this.wxpay_app_id = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.app_alert, i);
        parcel.writeParcelable(this.legal, i);
        parcel.writeString(this.wxpay_app_id);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.client_nonce);
        parcel.writeString(this.server_nonce);
    }

    public AppConfigCallbackEntity(Parcel parcel) {
        this.app_alert = (StoreMessageBean) parcel.readParcelable(StoreMessageBean.class.getClassLoader());
        this.legal = (PrivacyVersionBean) parcel.readParcelable(PrivacyVersionBean.class.getClassLoader());
        this.wxpay_app_id = parcel.readString();
        this.timestamp = parcel.readLong();
        this.client_nonce = parcel.readString();
        this.server_nonce = parcel.readString();
    }
}
