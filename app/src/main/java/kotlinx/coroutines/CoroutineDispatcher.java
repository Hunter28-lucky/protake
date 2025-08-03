package kotlinx.coroutines;

import defpackage.AbstractC3174;
import defpackage.AbstractC3175;
import defpackage.C2316;
import defpackage.C2317;
import defpackage.C4184;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC3235;
import defpackage.InterfaceC4355;
import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class CoroutineDispatcher extends AbstractC3174 implements InterfaceC3235 {
    public static final Key Key = new Key(null);

    /* compiled from: CoroutineDispatcher.kt */
    public static final class Key extends AbstractC3175<InterfaceC3235, CoroutineDispatcher> {
        public Key() {
            super(InterfaceC3235.f11395, new InterfaceC2392<CoroutineContext.InterfaceC2140, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // defpackage.InterfaceC2392
                /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
                public final CoroutineDispatcher invoke(CoroutineContext.InterfaceC2140 interfaceC2140) {
                    if (interfaceC2140 instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) interfaceC2140;
                    }
                    return null;
                }
            });
        }

        public /* synthetic */ Key(C4184 c4184) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(InterfaceC3235.f11395);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // defpackage.AbstractC3174, kotlin.coroutines.CoroutineContext.InterfaceC2140, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.InterfaceC2140> E get(CoroutineContext.InterfaceC2142<E> interfaceC2142) {
        return (E) InterfaceC3235.C3236.m10901(this, interfaceC2142);
    }

    @Override // defpackage.InterfaceC3235
    public final <T> InterfaceC4355<T> interceptContinuation(InterfaceC4355<? super T> interfaceC4355) {
        return new C2317(this, interfaceC4355);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    @Override // defpackage.AbstractC3174, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        return InterfaceC3235.C3236.m10902(this, interfaceC2142);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // defpackage.InterfaceC3235
    public void releaseInterceptedContinuation(InterfaceC4355<?> interfaceC4355) {
        ((C2317) interfaceC4355).m8701();
    }

    public String toString() {
        return C2316.m8690(this) + '@' + C2316.m8691(this);
    }
}
