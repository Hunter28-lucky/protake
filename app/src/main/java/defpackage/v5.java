package defpackage;

import java.util.Objects;

/* compiled from: VideoFpsEntity.java */
/* loaded from: classes.dex */
public class v5 extends C5159 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8662;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f8663;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f8664;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f8665;

    public v5(int i) {
        this.f8662 = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f8662 == ((v5) obj).f8662;
    }

    public int getType() {
        return this.f8663;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f8662));
    }

    public String toString() {
        return "VideoFpsEntity{fps=" + this.f8662 + ", type=" + this.f8663 + "} ";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m8464() {
        return this.f8662;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m8465() {
        return this.f8665;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m8466() {
        return this.f8664;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public v5 m8467(int i) {
        this.f8665 = i;
        return this;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public v5 m8468(int i) {
        this.f8663 = i;
        return this;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m8469(int i) {
        this.f8664 = i;
    }

    public v5() {
    }
}
