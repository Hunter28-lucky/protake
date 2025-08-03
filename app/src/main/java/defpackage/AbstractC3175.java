package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.InterfaceC2140;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: Ԯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3175<B extends CoroutineContext.InterfaceC2140, E extends B> implements CoroutineContext.InterfaceC2142<E> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2392<CoroutineContext.InterfaceC2140, E> f11253;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final CoroutineContext.InterfaceC2142<?> f11254;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Ԩ<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, ŭ<? super kotlin.coroutines.CoroutineContext$Ϳ, ? extends E extends B>, ŭ<kotlin.coroutines.CoroutineContext$Ϳ, E extends B>] */
    public AbstractC3175(CoroutineContext.InterfaceC2142<B> interfaceC2142, InterfaceC2392<? super CoroutineContext.InterfaceC2140, ? extends E> interfaceC2392) {
        C3921.m12666(interfaceC2142, "baseKey");
        C3921.m12666(interfaceC2392, "safeCast");
        this.f11253 = interfaceC2392;
        this.f11254 = interfaceC2142 instanceof AbstractC3175 ? (CoroutineContext.InterfaceC2142<B>) ((AbstractC3175) interfaceC2142).f11254 : interfaceC2142;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m10782(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        return interfaceC2142 == this || this.f11254 == interfaceC2142;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Ϳ;)TE; */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final CoroutineContext.InterfaceC2140 m10783(CoroutineContext.InterfaceC2140 interfaceC2140) {
        C3921.m12666(interfaceC2140, "element");
        return (CoroutineContext.InterfaceC2140) this.f11253.invoke(interfaceC2140);
    }
}
