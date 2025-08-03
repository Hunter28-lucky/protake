package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableDefer.java */
/* renamed from: ಔ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4607<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2856<? extends T>> f15703;

    public C4607(Callable<? extends InterfaceC2856<? extends T>> callable) {
        this.f15703 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            ((InterfaceC2856) C4246.m13353(this.f15703.call(), "null ObservableSource supplied")).subscribe(interfaceC5102);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
