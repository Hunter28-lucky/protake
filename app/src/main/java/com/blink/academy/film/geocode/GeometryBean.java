package com.blink.academy.film.geocode;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GeometryBean implements Parcelable {
    public static final Parcelable.Creator<GeometryBean> CREATOR = new C0121();

    /* renamed from: ԫ, reason: contains not printable characters */
    public BoundsBean f415;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public LatLonInfoBean f416;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f417;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public BoundsBean f418;

    /* renamed from: com.blink.academy.film.geocode.GeometryBean$Ϳ, reason: contains not printable characters */
    public class C0121 implements Parcelable.Creator<GeometryBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public GeometryBean createFromParcel(Parcel parcel) {
            return new GeometryBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public GeometryBean[] newArray(int i) {
            return new GeometryBean[i];
        }
    }

    public GeometryBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f415, i);
        parcel.writeParcelable(this.f416, i);
        parcel.writeString(this.f417);
        parcel.writeParcelable(this.f418, i);
    }

    public GeometryBean(Parcel parcel) {
        this.f415 = (BoundsBean) parcel.readParcelable(BoundsBean.class.getClassLoader());
        this.f416 = (LatLonInfoBean) parcel.readParcelable(LatLonInfoBean.class.getClassLoader());
        this.f417 = parcel.readString();
        this.f418 = (BoundsBean) parcel.readParcelable(BoundsBean.class.getClassLoader());
    }
}
