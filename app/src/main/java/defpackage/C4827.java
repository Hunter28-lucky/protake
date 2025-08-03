package defpackage;

import defpackage.C3690;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableReduceWithSingle.java */
/* renamed from: ථ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4827<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16325;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<R> f16326;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f16327;

    public C4827(InterfaceC2856<T> interfaceC2856, Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        this.f16325 = interfaceC2856;
        this.f16326 = callable;
        this.f16327 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        try {
            this.f16325.subscribe(new C3690.C3691(interfaceC4782, this.f16327, C4246.m13353(this.f16326.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }
}
