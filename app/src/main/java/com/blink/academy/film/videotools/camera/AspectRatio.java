package com.blink.academy.film.videotools.camera;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C2375;

/* loaded from: classes.dex */
public class AspectRatio implements Comparable<AspectRatio>, Parcelable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f1851;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f1852;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final SparseArrayCompat<SparseArrayCompat<AspectRatio>> f1850 = new SparseArrayCompat<>(16);
    public static final Parcelable.Creator<AspectRatio> CREATOR = new C0850();

    /* renamed from: com.blink.academy.film.videotools.camera.AspectRatio$Ϳ, reason: contains not printable characters */
    public class C0850 implements Parcelable.Creator<AspectRatio> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.m2074(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    }

    public AspectRatio(int i, int i2) {
        this.f1851 = i;
        this.f1852 = i2;
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public static int m2073(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public static AspectRatio m2074(int i, int i2) {
        int iM2073 = m2073(i, i2);
        int i3 = i / iM2073;
        int i4 = i2 / iM2073;
        SparseArrayCompat<SparseArrayCompat<AspectRatio>> sparseArrayCompat = f1850;
        SparseArrayCompat<AspectRatio> sparseArrayCompat2 = sparseArrayCompat.get(i3);
        if (sparseArrayCompat2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i3, i4);
            SparseArrayCompat<AspectRatio> sparseArrayCompat3 = new SparseArrayCompat<>();
            sparseArrayCompat3.put(i4, aspectRatio);
            sparseArrayCompat.put(i3, sparseArrayCompat3);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = sparseArrayCompat2.get(i4);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio aspectRatio3 = new AspectRatio(i3, i4);
        sparseArrayCompat2.put(i4, aspectRatio3);
        return aspectRatio3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspectRatio)) {
            return false;
        }
        AspectRatio aspectRatio = (AspectRatio) obj;
        return this.f1851 == aspectRatio.f1851 && this.f1852 == aspectRatio.f1852;
    }

    public int hashCode() {
        int i = this.f1852;
        int i2 = this.f1851;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f1851 + Constants.COLON_SEPARATOR + this.f1852;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1851);
        parcel.writeInt(this.f1852);
    }

    @Override // java.lang.Comparable
    /* renamed from: ຉ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int compareTo(@NonNull AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return m2077() - aspectRatio.m2077() > 0.0f ? 1 : -1;
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public boolean m2076(C2375 c2375) {
        int iM2073 = m2073(c2375.m8846(), c2375.m8843());
        return this.f1851 == c2375.m8846() / iM2073 && this.f1852 == c2375.m8843() / iM2073;
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public float m2077() {
        return this.f1851 / this.f1852;
    }
}
