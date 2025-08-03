package kotlin.coroutines.jvm.internal;

import defpackage.InterfaceC4355;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(InterfaceC4355<Object> interfaceC4355) {
        super(interfaceC4355);
        if (interfaceC4355 != null) {
            if (!(interfaceC4355.getContext() == EmptyCoroutineContext.f7835)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f7835;
    }
}
