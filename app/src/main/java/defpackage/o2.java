package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Timed.java */
/* loaded from: classes2.dex */
public final class o2<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final T f8072;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final long f8073;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final TimeUnit f8074;

    public o2(T t, long j, TimeUnit timeUnit) {
        this.f8072 = t;
        this.f8073 = j;
        this.f8074 = (TimeUnit) C4246.m13353(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return C4246.m13351(this.f8072, o2Var.f8072) && this.f8073 == o2Var.f8073 && C4246.m13351(this.f8074, o2Var.f8074);
    }

    public int hashCode() {
        T t = this.f8072;
        int iHashCode = t != null ? t.hashCode() : 0;
        long j = this.f8073;
        return (((iHashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f8074.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f8073 + ", unit=" + this.f8074 + ", value=" + this.f8072 + "]";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long m7667() {
        return this.f8073;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public T m7668() {
        return this.f8072;
    }
}
