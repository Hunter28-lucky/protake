package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: ContinuationInterceptor.kt */
/* renamed from: է, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC3235 extends CoroutineContext.InterfaceC2140 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C3237 f11395 = C3237.f11396;

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: է$Ϳ, reason: contains not printable characters */
    public static final class C3236 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static <E extends CoroutineContext.InterfaceC2140> E m10901(InterfaceC3235 interfaceC3235, CoroutineContext.InterfaceC2142<E> interfaceC2142) {
            C3921.m12666(interfaceC2142, "key");
            if (!(interfaceC2142 instanceof AbstractC3175)) {
                if (InterfaceC3235.f11395 == interfaceC2142) {
                    return interfaceC3235;
                }
                return null;
            }
            AbstractC3175 abstractC3175 = (AbstractC3175) interfaceC2142;
            if (!abstractC3175.m10782(interfaceC3235.getKey())) {
                return null;
            }
            E e2 = (E) abstractC3175.m10783(interfaceC3235);
            if (e2 instanceof CoroutineContext.InterfaceC2140) {
                return e2;
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static CoroutineContext m10902(InterfaceC3235 interfaceC3235, CoroutineContext.InterfaceC2142<?> interfaceC2142) {
            C3921.m12666(interfaceC2142, "key");
            if (!(interfaceC2142 instanceof AbstractC3175)) {
                return InterfaceC3235.f11395 == interfaceC2142 ? EmptyCoroutineContext.f7835 : interfaceC3235;
            }
            AbstractC3175 abstractC3175 = (AbstractC3175) interfaceC2142;
            return (!abstractC3175.m10782(interfaceC3235.getKey()) || abstractC3175.m10783(interfaceC3235) == null) ? interfaceC3235 : EmptyCoroutineContext.f7835;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* renamed from: է$Ԩ, reason: contains not printable characters */
    public static final class C3237 implements CoroutineContext.InterfaceC2142<InterfaceC3235> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final /* synthetic */ C3237 f11396 = new C3237();
    }

    <T> InterfaceC4355<T> interceptContinuation(InterfaceC4355<? super T> interfaceC4355);

    void releaseInterceptedContinuation(InterfaceC4355<?> interfaceC4355);
}
