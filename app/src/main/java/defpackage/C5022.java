package defpackage;

import defpackage.InterfaceC3235;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Builders.common.kt */
/* renamed from: ང, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final /* synthetic */ class C5022 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC5238 m14809(InterfaceC3539 interfaceC3539, CoroutineContext coroutineContext, CoroutineStart coroutineStart, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        CoroutineContext coroutineContextM10651 = C3079.m10651(interfaceC3539, coroutineContext);
        AbstractC3173 c4171 = coroutineStart.m7327() ? new C4171(coroutineContextM10651, interfaceC2849) : new f(coroutineContextM10651, true);
        c4171.m10781(coroutineStart, c4171, interfaceC2849);
        return c4171;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC5238 m14810(InterfaceC3539 interfaceC3539, CoroutineContext coroutineContext, CoroutineStart coroutineStart, InterfaceC2849 interfaceC2849, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f7835;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C2404.m8897(interfaceC3539, coroutineContext, coroutineStart, interfaceC2849);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final <T> Object m14811(CoroutineContext coroutineContext, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) throws Throwable {
        Object objM11741;
        CoroutineContext context = interfaceC4355.getContext();
        CoroutineContext coroutineContextPlus = context.plus(coroutineContext);
        C4428.m13663(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            C4470 c4470 = new C4470(coroutineContextPlus, interfaceC4355);
            objM11741 = g4.m6076(c4470, c4470, interfaceC2849);
        } else {
            InterfaceC3235.C3237 c3237 = InterfaceC3235.f11395;
            if (C3921.m12662(coroutineContextPlus.get(c3237), context.get(c3237))) {
                f4 f4Var = new f4(coroutineContextPlus, interfaceC4355);
                Object objM7372 = ThreadContextKt.m7372(coroutineContextPlus, null);
                try {
                    Object objM6076 = g4.m6076(f4Var, f4Var, interfaceC2849);
                    ThreadContextKt.m7370(coroutineContextPlus, objM7372);
                    objM11741 = objM6076;
                } catch (Throwable th) {
                    ThreadContextKt.m7370(coroutineContextPlus, objM7372);
                    throw th;
                }
            } else {
                C3657 c3657 = new C3657(coroutineContextPlus, interfaceC4355);
                C2596.m9499(interfaceC2849, c3657, c3657, null, 4, null);
                objM11741 = c3657.m11741();
            }
        }
        if (objM11741 == C5199.m15170()) {
            C5148.m15061(interfaceC4355);
        }
        return objM11741;
    }
}
