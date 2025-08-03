package defpackage;

import kotlin.Result;

/* compiled from: CompletionState.kt */
/* renamed from: ɫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2609 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> Object m9541(Object obj, InterfaceC4355<? super T> interfaceC4355) {
        if (!(obj instanceof C2823)) {
            return Result.m7211(obj);
        }
        Result.C2137 c2137 = Result.f7828;
        return Result.m7211(C4817.m14541(((C2823) obj).f10293));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> Object m9542(Object obj, InterfaceC5005<?> interfaceC5005) {
        Throwable thM7213 = Result.m7213(obj);
        return thM7213 == null ? obj : new C2823(thM7213, false, 2, null);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <T> Object m9543(Object obj, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        Throwable thM7213 = Result.m7213(obj);
        return thM7213 == null ? interfaceC2392 != null ? new C3183(obj, interfaceC2392) : obj : new C2823(thM7213, false, 2, null);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ Object m9544(Object obj, InterfaceC2392 interfaceC2392, int i, Object obj2) {
        if ((i & 1) != 0) {
            interfaceC2392 = null;
        }
        return m9543(obj, interfaceC2392);
    }
}
