package defpackage;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineContextImpl.kt */
/* renamed from: Ԭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3174 implements CoroutineContext.InterfaceC2140 {
    private final CoroutineContext.InterfaceC2142<?> key;

    public AbstractC3174(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        this.key = interfaceC2142;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, InterfaceC2849<? super R, ? super CoroutineContext.InterfaceC2140, ? extends R> interfaceC2849) {
        return (R) CoroutineContext.InterfaceC2140.C2141.m7249(this, r, interfaceC2849);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC2140, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.InterfaceC2140> E get(CoroutineContext.InterfaceC2142<E> interfaceC2142) {
        return (E) CoroutineContext.InterfaceC2140.C2141.m7250(this, interfaceC2142);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC2140
    public CoroutineContext.InterfaceC2142<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        return CoroutineContext.InterfaceC2140.C2141.m7251(this, interfaceC2142);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.InterfaceC2140.C2141.m7252(this, coroutineContext);
    }
}
