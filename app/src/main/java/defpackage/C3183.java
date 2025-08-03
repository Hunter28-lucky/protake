package defpackage;

/* compiled from: CompletionState.kt */
/* renamed from: Ի, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3183 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f11264;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2392<Throwable, i4> f11265;

    /* JADX WARN: Multi-variable type inference failed */
    public C3183(Object obj, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        this.f11264 = obj;
        this.f11265 = interfaceC2392;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3183)) {
            return false;
        }
        C3183 c3183 = (C3183) obj;
        return C3921.m12662(this.f11264, c3183.f11264) && C3921.m12662(this.f11265, c3183.f11265);
    }

    public int hashCode() {
        Object obj = this.f11264;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f11265.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f11264 + ", onCancellation=" + this.f11265 + ')';
    }
}
