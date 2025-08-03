package defpackage;

/* renamed from: ଈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4390 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f15101;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f15102;

    public C4390(int i, int i2) {
        this.f15101 = i;
        this.f15102 = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4390)) {
            return false;
        }
        C4390 c4390 = (C4390) obj;
        return this.f15101 == c4390.f15101 && this.f15102 == c4390.f15102;
    }

    public int hashCode() {
        int i = this.f15102;
        int i2 = this.f15101;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f15101 + C4625.m14082("Ng==") + this.f15102;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m13583() {
        return this.f15102;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m13584() {
        return this.f15101;
    }
}
