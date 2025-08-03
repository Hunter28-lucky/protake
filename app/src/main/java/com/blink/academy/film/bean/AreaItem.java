package com.blink.academy.film.bean;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.InterfaceC3511;

/* loaded from: classes.dex */
public class AreaItem implements InterfaceC3511, Parcelable {
    public static final Parcelable.Creator<AreaItem> CREATOR = new C0113();

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f392;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f393;

    /* renamed from: com.blink.academy.film.bean.AreaItem$Ϳ, reason: contains not printable characters */
    public class C0113 implements Parcelable.Creator<AreaItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AreaItem createFromParcel(Parcel parcel) {
            return new AreaItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AreaItem[] newArray(int i) {
            return new AreaItem[i];
        }
    }

    public AreaItem(String str, String str2) {
        this.f392 = str;
        this.f393 = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f392);
        parcel.writeString(this.f393);
    }

    @Override // defpackage.InterfaceC3511
    /* renamed from: ຉ, reason: contains not printable characters */
    public String mo463() {
        return this.f392 + " +" + this.f393;
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public String m464() {
        return this.f392;
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public String m465() {
        return this.f393;
    }

    public AreaItem() {
    }

    public AreaItem(Parcel parcel) {
        this.f392 = parcel.readString();
        this.f393 = parcel.readString();
    }
}
