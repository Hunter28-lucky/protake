package kotlin;

import defpackage.C3921;
import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return C3921.m12662(this.first, pair.first) && C3921.m12662(this.second, pair.second);
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b = this.second;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final A m7207() {
        return this.first;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final B m7208() {
        return this.second;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final A m7209() {
        return this.first;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final B m7210() {
        return this.second;
    }
}
