package defpackage;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* renamed from: ٮ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3490 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> void m11405(AbstractC2893<? super T> abstractC2893, int i) {
        InterfaceC4355<? super T> interfaceC4355Mo8694 = abstractC2893.mo8694();
        boolean z = i == 4;
        if (z || !(interfaceC4355Mo8694 instanceof C2317) || m11406(i) != m11406(abstractC2893.f10568)) {
            m11408(abstractC2893, interfaceC4355Mo8694, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((C2317) interfaceC4355Mo8694).f8803;
        CoroutineContext context = interfaceC4355Mo8694.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, abstractC2893);
        } else {
            m11409(abstractC2893);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final boolean m11406(int i) {
        return i == 1 || i == 2;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final boolean m11407(int i) {
        return i == 2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final <T> void m11408(AbstractC2893<? super T> abstractC2893, InterfaceC4355<? super T> interfaceC4355, boolean z) {
        Object objMo10262;
        Object objMo8695 = abstractC2893.mo8695();
        Throwable thMo10261 = abstractC2893.mo10261(objMo8695);
        if (thMo10261 != null) {
            Result.C2137 c2137 = Result.f7828;
            objMo10262 = C4817.m14541(thMo10261);
        } else {
            Result.C2137 c21372 = Result.f7828;
            objMo10262 = abstractC2893.mo10262(objMo8695);
        }
        Object objM7211 = Result.m7211(objMo10262);
        if (!z) {
            interfaceC4355.resumeWith(objM7211);
            return;
        }
        C2317 c2317 = (C2317) interfaceC4355;
        InterfaceC4355<T> interfaceC43552 = c2317.f8804;
        Object obj = c2317.f8806;
        CoroutineContext context = interfaceC43552.getContext();
        Object objM7372 = ThreadContextKt.m7372(context, obj);
        f4<?> f4VarM10653 = objM7372 != ThreadContextKt.f7879 ? C3079.m10653(interfaceC43552, context, objM7372) : null;
        try {
            c2317.f8804.resumeWith(objM7211);
            i4 i4Var = i4.f6762;
        } finally {
            if (f4VarM10653 == null || f4VarM10653.m6050()) {
                ThreadContextKt.m7370(context, objM7372);
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final void m11409(AbstractC2893<?> abstractC2893) {
        AbstractC2333 abstractC2333M5985 = e2.f6600.m5985();
        if (abstractC2333M5985.m8743()) {
            abstractC2333M5985.m8741(abstractC2893);
            return;
        }
        abstractC2333M5985.m8742(true);
        try {
            m11408(abstractC2893, abstractC2893.mo8694(), true);
            do {
            } while (abstractC2333M5985.m8745());
        } finally {
            try {
            } finally {
            }
        }
    }
}
