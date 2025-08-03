package kotlin.coroutines.jvm.internal;

import defpackage.C3519;
import defpackage.C3921;
import defpackage.InterfaceC3235;
import defpackage.InterfaceC4355;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient InterfaceC4355<Object> intercepted;

    public ContinuationImpl(InterfaceC4355<Object> interfaceC4355, CoroutineContext coroutineContext) {
        super(interfaceC4355);
        this._context = coroutineContext;
    }

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        C3921.m12664(coroutineContext);
        return coroutineContext;
    }

    public final InterfaceC4355<Object> intercepted() {
        InterfaceC4355<Object> interfaceC4355InterceptContinuation = this.intercepted;
        if (interfaceC4355InterceptContinuation == null) {
            InterfaceC3235 interfaceC3235 = (InterfaceC3235) getContext().get(InterfaceC3235.f11395);
            if (interfaceC3235 == null || (interfaceC4355InterceptContinuation = interfaceC3235.interceptContinuation(this)) == null) {
                interfaceC4355InterceptContinuation = this;
            }
            this.intercepted = interfaceC4355InterceptContinuation;
        }
        return interfaceC4355InterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        InterfaceC4355<?> interfaceC4355 = this.intercepted;
        if (interfaceC4355 != null && interfaceC4355 != this) {
            CoroutineContext.InterfaceC2140 interfaceC2140 = getContext().get(InterfaceC3235.f11395);
            C3921.m12664(interfaceC2140);
            ((InterfaceC3235) interfaceC2140).releaseInterceptedContinuation(interfaceC4355);
        }
        this.intercepted = C3519.f12308;
    }

    public ContinuationImpl(InterfaceC4355<Object> interfaceC4355) {
        this(interfaceC4355, interfaceC4355 != null ? interfaceC4355.getContext() : null);
    }
}
