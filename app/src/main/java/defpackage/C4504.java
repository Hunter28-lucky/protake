package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: SingleDefer.java */
/* renamed from: ఊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4504<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC3951<? extends T>> f15421;

    public C4504(Callable<? extends InterfaceC3951<? extends T>> callable) {
        this.f15421 = callable;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        try {
            ((InterfaceC3951) C4246.m13353(this.f15421.call(), "The singleSupplier returned a null SingleSource")).subscribe(interfaceC4782);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }
}
