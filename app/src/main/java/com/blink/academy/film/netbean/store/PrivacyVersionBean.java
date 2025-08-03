package com.blink.academy.film.netbean.store;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PrivacyVersionBean implements Parcelable {
    public static final Parcelable.Creator<PrivacyVersionBean> CREATOR = new C0448();
    private String privacy_version;
    private int privacy_version_integer;
    private String terms_version;
    private int terms_version_integer;

    /* renamed from: com.blink.academy.film.netbean.store.PrivacyVersionBean$Ϳ, reason: contains not printable characters */
    public class C0448 implements Parcelable.Creator<PrivacyVersionBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public PrivacyVersionBean createFromParcel(Parcel parcel) {
            return new PrivacyVersionBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public PrivacyVersionBean[] newArray(int i) {
            return new PrivacyVersionBean[i];
        }
    }

    public PrivacyVersionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPrivacy_version() {
        return this.privacy_version;
    }

    public int getPrivacy_version_integer() {
        return this.privacy_version_integer;
    }

    public String getTerms_version() {
        return this.terms_version;
    }

    public int getTerms_version_integer() {
        return this.terms_version_integer;
    }

    public PrivacyVersionBean setPrivacy_version(String str) {
        this.privacy_version = str;
        return this;
    }

    public PrivacyVersionBean setPrivacy_version_integer(int i) {
        this.privacy_version_integer = i;
        return this;
    }

    public void setTerms_version(String str) {
        this.terms_version = str;
    }

    public void setTerms_version_integer(int i) {
        this.terms_version_integer = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.privacy_version_integer);
        parcel.writeString(this.privacy_version);
        parcel.writeInt(this.terms_version_integer);
        parcel.writeString(this.terms_version);
    }

    public PrivacyVersionBean(Parcel parcel) {
        this.privacy_version_integer = parcel.readInt();
        this.privacy_version = parcel.readString();
        this.terms_version_integer = parcel.readInt();
        this.terms_version = parcel.readString();
    }
}
