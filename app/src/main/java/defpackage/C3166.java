package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableNever.java */
/* renamed from: ԡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3166 extends AbstractC4262<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC4262<Object> f11233 = new C3166();

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Object> interfaceC5102) {
        interfaceC5102.onSubscribe(EmptyDisposable.NEVER);
    }
}
