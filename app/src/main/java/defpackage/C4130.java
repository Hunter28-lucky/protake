package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableEmpty.java */
/* renamed from: ॼ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4130 extends AbstractC4262<Object> implements InterfaceCallableC5143<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC4262<Object> f14309 = new C4130();

    @Override // defpackage.InterfaceCallableC5143, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Object> interfaceC5102) {
        EmptyDisposable.complete(interfaceC5102);
    }
}
