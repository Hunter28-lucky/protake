package defpackage;

import java.util.Objects;

/* compiled from: SafeAreaEntity.java */
/* renamed from: ஐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4460 extends C5159 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float f15344;

    public C4460(float f) {
        this.f15344 = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Float.compare(((C4460) obj).f15344, this.f15344) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f15344));
    }

    public String toString() {
        return ((int) (this.f15344 * 100.0f)) + "%";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float m13721() {
        return this.f15344;
    }
}
