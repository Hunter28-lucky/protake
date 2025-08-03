package defpackage;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Undispatched.kt */
/* loaded from: classes2.dex */
public final class g4 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <R, T> void m6075(InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, R r, InterfaceC4355<? super T> interfaceC4355) {
        InterfaceC4355 interfaceC4355M15059 = C5148.m15059(interfaceC4355);
        try {
            CoroutineContext context = interfaceC4355.getContext();
            Object objM7372 = ThreadContextKt.m7372(context, null);
            try {
                if (interfaceC2849 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
                Object objInvoke = ((InterfaceC2849) u3.m8339(interfaceC2849, 2)).invoke(r, interfaceC4355M15059);
                if (objInvoke != C5199.m15170()) {
                    interfaceC4355M15059.resumeWith(Result.m7211(objInvoke));
                }
            } finally {
                ThreadContextKt.m7370(context, objM7372);
            }
        } catch (Throwable th) {
            Result.C2137 c2137 = Result.f7828;
            interfaceC4355M15059.resumeWith(Result.m7211(C4817.m14541(th)));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T, R> Object m6076(C4470<? super T> c4470, R r, InterfaceC2849<? super R, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849) throws Throwable {
        Object c2823;
        try {
        } catch (Throwable th) {
            c2823 = new C2823(th, false, 2, null);
        }
        if (interfaceC2849 == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        c2823 = ((InterfaceC2849) u3.m8339(interfaceC2849, 2)).invoke(r, c4470);
        if (c2823 == C5199.m15170()) {
            return C5199.m15170();
        }
        Object objM9866 = c4470.m9866(c2823);
        if (objM9866 == C4479.f15381) {
            return C5199.m15170();
        }
        if (objM9866 instanceof C2823) {
            throw ((C2823) objM9866).f10293;
        }
        return C4479.m13735(objM9866);
    }
}
