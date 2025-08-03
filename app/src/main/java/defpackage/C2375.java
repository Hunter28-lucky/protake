package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CameraSize.java */
/* renamed from: ř, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2375 implements Comparable<C2375> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f8925;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f8926;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f8927;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f8928;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f8929;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f8930;

    public C2375(int i, int i2) {
        this.f8929 = i;
        this.f8930 = i2;
        this.f8925 = i * i2;
        this.f8926 = (i * 1.0f) / i2;
        this.f8927 = i + "*" + i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2375)) {
            return false;
        }
        C2375 c2375 = (C2375) obj;
        return this.f8929 == c2375.f8929 && this.f8930 == c2375.f8930;
    }

    public int hashCode() {
        int i = this.f8930;
        int i2 = this.f8929;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f8927;
    }

    @Override // java.lang.Comparable
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public int compareTo(@NonNull C2375 c2375) {
        return (c2375.f8929 * c2375.f8930) - (this.f8929 * this.f8930);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m8843() {
        return this.f8930;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public long m8844() {
        return this.f8925;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m8845() {
        return this.f8928;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m8846() {
        return this.f8929;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C2375 m8847(String str) {
        this.f8928 = str;
        return this;
    }
}
