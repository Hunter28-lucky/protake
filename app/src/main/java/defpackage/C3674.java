package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: MultiClassKey.java */
/* renamed from: ܟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3674 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Class<?> f12748;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Class<?> f12749;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Class<?> f12750;

    public C3674() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3674 c3674 = (C3674) obj;
        return this.f12748.equals(c3674.f12748) && this.f12749.equals(c3674.f12749) && j5.m7086(this.f12750, c3674.f12750);
    }

    public int hashCode() {
        int iHashCode = ((this.f12748.hashCode() * 31) + this.f12749.hashCode()) * 31;
        Class<?> cls = this.f12750;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f12748 + ", second=" + this.f12749 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m11818(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m11819(cls, cls2, null);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m11819(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f12748 = cls;
        this.f12749 = cls2;
        this.f12750 = cls3;
    }

    public C3674(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m11818(cls, cls2);
    }

    public C3674(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        m11819(cls, cls2, cls3);
    }
}
