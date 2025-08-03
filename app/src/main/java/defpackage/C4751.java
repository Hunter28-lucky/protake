package defpackage;

import io.reactivex.disposables.C1972;

/* compiled from: SingleJust.java */
/* renamed from: ൠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4751<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T f16023;

    public C4751(T t) {
        this.f16023 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        interfaceC4782.onSubscribe(C1972.m6299());
        interfaceC4782.onSuccess(this.f16023);
    }
}
