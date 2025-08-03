package defpackage;

import defpackage.C3127;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* compiled from: FlowableReduceWithSingle.java */
/* renamed from: ϓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2836<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f10312;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<R> f10313;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f10314;

    public C2836(Publisher<T> publisher, Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        this.f10312 = publisher;
        this.f10313 = callable;
        this.f10314 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        try {
            this.f10312.subscribe(new C3127.C3128(interfaceC4782, this.f10314, C4246.m13353(this.f10313.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }
}
