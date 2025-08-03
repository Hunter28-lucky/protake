package defpackage;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;

/* compiled from: ConnectableObservable.java */
/* renamed from: ຈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4945<T> extends AbstractC4262<T> {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public AbstractC4262<T> m14715(int i) {
        return m14716(i, Functions.m6320());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public AbstractC4262<T> m14716(int i, InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        if (i > 0) {
            return C3671.m11798(new C4630(this, i, interfaceC2857));
        }
        mo6834(interfaceC2857);
        return C3671.m11795(this);
    }

    /* renamed from: ԫ */
    public abstract void mo6834(InterfaceC2857<? super InterfaceC4478> interfaceC2857);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4945<T> m14717() {
        return this instanceof InterfaceC2664 ? C3671.m11795(new ObservablePublishAlt(((InterfaceC2664) this).mo6833())) : this;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public AbstractC4262<T> m14718() {
        return C3671.m11798(new ObservableRefCount(m14717()));
    }
}
