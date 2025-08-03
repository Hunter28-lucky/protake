package kotlin.coroutines.jvm.internal;

import defpackage.C2921;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5148;
import defpackage.C5199;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC4472;
import defpackage.i4;
import java.io.Serializable;
import kotlin.Result;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class BaseContinuationImpl implements InterfaceC4355<Object>, InterfaceC4472, Serializable {
    private final InterfaceC4355<Object> completion;

    public BaseContinuationImpl(InterfaceC4355<Object> interfaceC4355) {
        this.completion = interfaceC4355;
    }

    public InterfaceC4355<i4> create(InterfaceC4355<?> interfaceC4355) {
        C3921.m12666(interfaceC4355, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.InterfaceC4472
    public InterfaceC4472 getCallerFrame() {
        InterfaceC4355<Object> interfaceC4355 = this.completion;
        if (interfaceC4355 instanceof InterfaceC4472) {
            return (InterfaceC4472) interfaceC4355;
        }
        return null;
    }

    public final InterfaceC4355<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return C2921.m10317(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC4355
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        InterfaceC4355 interfaceC4355 = this;
        while (true) {
            C5148.m15060(interfaceC4355);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) interfaceC4355;
            InterfaceC4355 interfaceC43552 = baseContinuationImpl.completion;
            C3921.m12664(interfaceC43552);
            try {
                objInvokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.C2137 c2137 = Result.f7828;
                obj = Result.m7211(C4817.m14541(th));
            }
            if (objInvokeSuspend == C5199.m15170()) {
                return;
            }
            obj = Result.m7211(objInvokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(interfaceC43552 instanceof BaseContinuationImpl)) {
                interfaceC43552.resumeWith(obj);
                return;
            }
            interfaceC4355 = interfaceC43552;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        C3921.m12666(interfaceC4355, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
