package com.blink.academy.film.geocode;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BoundsBean implements Parcelable {
    public static final Parcelable.Creator<BoundsBean> CREATOR = new C0120();

    /* renamed from: ԫ, reason: contains not printable characters */
    public LatLonInfoBean f413;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LatLonInfoBean f414;

    /* renamed from: com.blink.academy.film.geocode.BoundsBean$Ϳ, reason: contains not printable characters */
    public class C0120 implements Parcelable.Creator<BoundsBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public BoundsBean createFromParcel(Parcel parcel) {
            return new BoundsBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public BoundsBean[] newArray(int i) {
            return new BoundsBean[i];
        }
    }

    public BoundsBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f413, i);
        parcel.writeParcelable(this.f414, i);
    }

    public BoundsBean(Parcel parcel) {
        this.f413 = (LatLonInfoBean) parcel.readParcelable(LatLonInfoBean.class.getClassLoader());
        this.f414 = (LatLonInfoBean) parcel.readParcelable(LatLonInfoBean.class.getClassLoader());
    }
}
