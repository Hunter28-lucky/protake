package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: ѷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2946 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final r0 f10662 = new r0("UNDEFINED");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final r0 f10663 = new r0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> void m10349(InterfaceC4355<? super T> interfaceC4355, Object obj, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        boolean z;
        if (!(interfaceC4355 instanceof C2317)) {
            interfaceC4355.resumeWith(obj);
            return;
        }
        C2317 c2317 = (C2317) interfaceC4355;
        Object objM9543 = C2609.m9543(obj, interfaceC2392);
        if (c2317.f8803.isDispatchNeeded(c2317.getContext())) {
            c2317.f8805 = objM9543;
            c2317.f10568 = 1;
            c2317.f8803.dispatch(c2317.getContext(), c2317);
            return;
        }
        AbstractC2333 abstractC2333M5985 = e2.f6600.m5985();
        if (abstractC2333M5985.m8743()) {
            c2317.f8805 = objM9543;
            c2317.f10568 = 1;
            abstractC2333M5985.m8741(c2317);
            return;
        }
        abstractC2333M5985.m8742(true);
        try {
            InterfaceC5238 interfaceC5238 = (InterfaceC5238) c2317.getContext().get(InterfaceC5238.f17362);
            if (interfaceC5238 == null || interfaceC5238.mo9831()) {
                z = false;
            } else {
                CancellationException cancellationExceptionMo9834 = interfaceC5238.mo9834();
                c2317.mo8693(objM9543, cancellationExceptionMo9834);
                Result.C2137 c2137 = Result.f7828;
                c2317.resumeWith(Result.m7211(C4817.m14541(cancellationExceptionMo9834)));
                z = true;
            }
            if (!z) {
                InterfaceC4355<T> interfaceC43552 = c2317.f8804;
                Object obj2 = c2317.f8806;
                CoroutineContext context = interfaceC43552.getContext();
                Object objM7372 = ThreadContextKt.m7372(context, obj2);
                f4<?> f4VarM10653 = objM7372 != ThreadContextKt.f7879 ? C3079.m10653(interfaceC43552, context, objM7372) : null;
                try {
                    c2317.f8804.resumeWith(obj);
                    i4 i4Var = i4.f6762;
                    if (f4VarM10653 == null || f4VarM10653.m6050()) {
                        ThreadContextKt.m7370(context, objM7372);
                    }
                } catch (Throwable th) {
                    if (f4VarM10653 == null || f4VarM10653.m6050()) {
                        ThreadContextKt.m7370(context, objM7372);
                    }
                    throw th;
                }
            }
            while (abstractC2333M5985.m8745()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ void m10350(InterfaceC4355 interfaceC4355, Object obj, InterfaceC2392 interfaceC2392, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC2392 = null;
        }
        m10349(interfaceC4355, obj, interfaceC2392);
    }
}
