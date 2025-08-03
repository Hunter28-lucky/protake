package defpackage;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: ཀ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5018 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f16779;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final AbstractC3820 f16780;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC2392<Throwable, i4> f16781;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Object f16782;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Throwable f16783;

    /* JADX WARN: Multi-variable type inference failed */
    public C5018(Object obj, AbstractC3820 abstractC3820, InterfaceC2392<? super Throwable, i4> interfaceC2392, Object obj2, Throwable th) {
        this.f16779 = obj;
        this.f16780 = abstractC3820;
        this.f16781 = interfaceC2392;
        this.f16782 = obj2;
        this.f16783 = th;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ C5018 m14804(C5018 c5018, Object obj, AbstractC3820 abstractC3820, InterfaceC2392 interfaceC2392, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c5018.f16779;
        }
        if ((i & 2) != 0) {
            abstractC3820 = c5018.f16780;
        }
        AbstractC3820 abstractC38202 = abstractC3820;
        if ((i & 4) != 0) {
            interfaceC2392 = c5018.f16781;
        }
        InterfaceC2392 interfaceC23922 = interfaceC2392;
        if ((i & 8) != 0) {
            obj2 = c5018.f16782;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c5018.f16783;
        }
        return c5018.m14805(obj, abstractC38202, interfaceC23922, obj4, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5018)) {
            return false;
        }
        C5018 c5018 = (C5018) obj;
        return C3921.m12662(this.f16779, c5018.f16779) && C3921.m12662(this.f16780, c5018.f16780) && C3921.m12662(this.f16781, c5018.f16781) && C3921.m12662(this.f16782, c5018.f16782) && C3921.m12662(this.f16783, c5018.f16783);
    }

    public int hashCode() {
        Object obj = this.f16779;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC3820 abstractC3820 = this.f16780;
        int iHashCode2 = (iHashCode + (abstractC3820 == null ? 0 : abstractC3820.hashCode())) * 31;
        InterfaceC2392<Throwable, i4> interfaceC2392 = this.f16781;
        int iHashCode3 = (iHashCode2 + (interfaceC2392 == null ? 0 : interfaceC2392.hashCode())) * 31;
        Object obj2 = this.f16782;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f16783;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f16779 + ", cancelHandler=" + this.f16780 + ", onCancellation=" + this.f16781 + ", idempotentResume=" + this.f16782 + ", cancelCause=" + this.f16783 + ')';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C5018 m14805(Object obj, AbstractC3820 abstractC3820, InterfaceC2392<? super Throwable, i4> interfaceC2392, Object obj2, Throwable th) {
        return new C5018(obj, abstractC3820, interfaceC2392, obj2, th);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m14806() {
        return this.f16783 != null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m14807(C4441<?> c4441, Throwable th) {
        AbstractC3820 abstractC3820 = this.f16780;
        if (abstractC3820 != null) {
            c4441.m13673(abstractC3820, th);
        }
        InterfaceC2392<Throwable, i4> interfaceC2392 = this.f16781;
        if (interfaceC2392 == null) {
            return;
        }
        c4441.m13675(interfaceC2392, th);
    }

    public /* synthetic */ C5018(Object obj, AbstractC3820 abstractC3820, InterfaceC2392 interfaceC2392, Object obj2, Throwable th, int i, C4184 c4184) {
        this(obj, (i & 2) != 0 ? null : abstractC3820, (i & 4) != 0 ? null : interfaceC2392, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
