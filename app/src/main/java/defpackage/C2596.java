package defpackage;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Cancellable.kt */
/* renamed from: ɨ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2596 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m9497(InterfaceC4355<? super i4> interfaceC4355, InterfaceC4355<?> interfaceC43552) {
        try {
            InterfaceC4355 interfaceC4355M7255 = IntrinsicsKt__IntrinsicsJvmKt.m7255(interfaceC4355);
            Result.C2137 c2137 = Result.f7828;
            C2946.m10350(interfaceC4355M7255, Result.m7211(i4.f6762), null, 2, null);
        } catch (Throwable th) {
            Result.C2137 c21372 = Result.f7828;
            interfaceC43552.resumeWith(Result.m7211(C4817.m14541(th)));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <R, T> void m9498(InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, R r, InterfaceC4355<? super T> interfaceC4355, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        try {
            InterfaceC4355 interfaceC4355M7255 = IntrinsicsKt__IntrinsicsJvmKt.m7255(IntrinsicsKt__IntrinsicsJvmKt.m7254(interfaceC2849, r, interfaceC4355));
            Result.C2137 c2137 = Result.f7828;
            C2946.m10349(interfaceC4355M7255, Result.m7211(i4.f6762), interfaceC2392);
        } catch (Throwable th) {
            Result.C2137 c21372 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(C4817.m14541(th)));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ void m9499(InterfaceC2849 interfaceC2849, Object obj, InterfaceC4355 interfaceC4355, InterfaceC2392 interfaceC2392, int i, Object obj2) {
        if ((i & 4) != 0) {
            interfaceC2392 = null;
        }
        m9498(interfaceC2849, obj, interfaceC4355, interfaceC2392);
    }
}
