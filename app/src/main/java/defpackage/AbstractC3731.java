package defpackage;

import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowableRefCount;

/* compiled from: ConnectableFlowable.java */
/* renamed from: ݚ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3731<T> extends AbstractC3630<T> {
    /* renamed from: Ԫ */
    public abstract void mo6552(InterfaceC2857<? super InterfaceC4478> interfaceC2857);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3731<T> m11939() {
        if (!(this instanceof InterfaceC4514)) {
            return this;
        }
        InterfaceC4514 interfaceC4514 = (InterfaceC4514) this;
        return C3671.m11794(new FlowablePublishAlt(interfaceC4514.mo6550(), interfaceC4514.mo6551()));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC3630<T> m11940() {
        return C3671.m11796(new FlowableRefCount(m11939()));
    }
}
