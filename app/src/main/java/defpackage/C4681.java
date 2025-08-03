package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: SingleLift.java */
/* renamed from: എ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4681<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f15892;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5259<? extends R, ? super T> f15893;

    public C4681(InterfaceC3951<T> interfaceC3951, InterfaceC5259<? extends R, ? super T> interfaceC5259) {
        this.f15892 = interfaceC3951;
        this.f15893 = interfaceC5259;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        try {
            this.f15892.subscribe((InterfaceC4782) C4246.m13353(this.f15893.m15300(interfaceC4782), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }
}
