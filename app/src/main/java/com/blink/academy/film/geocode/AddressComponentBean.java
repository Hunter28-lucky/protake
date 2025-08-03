package com.blink.academy.film.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class AddressComponentBean implements Parcelable {
    public static final Parcelable.Creator<AddressComponentBean> CREATOR = new C0119();

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f410;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f411;

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<String> f412;

    /* renamed from: com.blink.academy.film.geocode.AddressComponentBean$Ϳ, reason: contains not printable characters */
    public class C0119 implements Parcelable.Creator<AddressComponentBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AddressComponentBean createFromParcel(Parcel parcel) {
            return new AddressComponentBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AddressComponentBean[] newArray(int i) {
            return new AddressComponentBean[i];
        }
    }

    public AddressComponentBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f410);
        parcel.writeString(this.f411);
        parcel.writeStringList(this.f412);
    }

    public AddressComponentBean(Parcel parcel) {
        this.f410 = parcel.readString();
        this.f411 = parcel.readString();
        this.f412 = parcel.createStringArrayList();
    }
}
