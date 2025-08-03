package kotlinx.coroutines.internal;

import defpackage.C3921;
import defpackage.InterfaceC2849;
import defpackage.d2;
import defpackage.h2;
import defpackage.r0;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
public final class ThreadContextKt {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final r0 f7879 = new r0("NO_THREAD_ELEMENTS");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final InterfaceC2849<Object, CoroutineContext.InterfaceC2140, Object> f7880 = new InterfaceC2849<Object, CoroutineContext.InterfaceC2140, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // defpackage.InterfaceC2849
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, CoroutineContext.InterfaceC2140 interfaceC2140) {
            if (!(interfaceC2140 instanceof d2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num == null ? 1 : num.intValue();
            return iIntValue == 0 ? interfaceC2140 : Integer.valueOf(iIntValue + 1);
        }
    };

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final InterfaceC2849<d2<?>, CoroutineContext.InterfaceC2140, d2<?>> f7881 = new InterfaceC2849<d2<?>, CoroutineContext.InterfaceC2140, d2<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // defpackage.InterfaceC2849
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public final d2<?> invoke(d2<?> d2Var, CoroutineContext.InterfaceC2140 interfaceC2140) {
            if (d2Var != null) {
                return d2Var;
            }
            if (interfaceC2140 instanceof d2) {
                return (d2) interfaceC2140;
            }
            return null;
        }
    };

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final InterfaceC2849<h2, CoroutineContext.InterfaceC2140, h2> f7882 = new InterfaceC2849<h2, CoroutineContext.InterfaceC2140, h2>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // defpackage.InterfaceC2849
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public final h2 invoke(h2 h2Var, CoroutineContext.InterfaceC2140 interfaceC2140) {
            if (interfaceC2140 instanceof d2) {
                d2<?> d2Var = (d2) interfaceC2140;
                h2Var.m6179(d2Var, d2Var.m5915(h2Var.f6718));
            }
            return h2Var;
        }
    };

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m7370(CoroutineContext coroutineContext, Object obj) {
        if (obj == f7879) {
            return;
        }
        if (obj instanceof h2) {
            ((h2) obj).m6180(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f7881);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((d2) objFold).m5914(coroutineContext, obj);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Object m7371(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f7880);
        C3921.m12664(objFold);
        return objFold;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Object m7372(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = m7371(coroutineContext);
        }
        return obj == 0 ? f7879 : obj instanceof Integer ? coroutineContext.fold(new h2(coroutineContext, ((Number) obj).intValue()), f7882) : ((d2) obj).m5915(coroutineContext);
    }
}
