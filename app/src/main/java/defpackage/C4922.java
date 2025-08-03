package defpackage;

/* compiled from: CancellableContinuation.kt */
/* renamed from: า, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4922 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> C4441<T> m14650(InterfaceC4355<? super T> interfaceC4355) {
        if (!(interfaceC4355 instanceof C2317)) {
            return new C4441<>(interfaceC4355, 1);
        }
        C4441<T> c4441M8697 = ((C2317) interfaceC4355).m8697();
        if (c4441M8697 == null || !c4441M8697.m13696()) {
            c4441M8697 = null;
        }
        return c4441M8697 == null ? new C4441<>(interfaceC4355, 2) : c4441M8697;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final void m14651(InterfaceC5005<?> interfaceC5005, C3469 c3469) {
        interfaceC5005.mo13670(new C4215(c3469));
    }
}
