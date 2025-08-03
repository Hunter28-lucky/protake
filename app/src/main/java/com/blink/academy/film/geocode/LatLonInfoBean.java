package com.blink.academy.film.geocode;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LatLonInfoBean implements Parcelable {
    public static final Parcelable.Creator<LatLonInfoBean> CREATOR = new C0122();

    /* renamed from: ԫ, reason: contains not printable characters */
    public double f419;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public double f420;

    /* renamed from: com.blink.academy.film.geocode.LatLonInfoBean$Ϳ, reason: contains not printable characters */
    public class C0122 implements Parcelable.Creator<LatLonInfoBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public LatLonInfoBean createFromParcel(Parcel parcel) {
            return new LatLonInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public LatLonInfoBean[] newArray(int i) {
            return new LatLonInfoBean[i];
        }
    }

    public LatLonInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f419);
        parcel.writeDouble(this.f420);
    }

    public LatLonInfoBean(Parcel parcel) {
        this.f419 = parcel.readDouble();
        this.f420 = parcel.readDouble();
    }
}
