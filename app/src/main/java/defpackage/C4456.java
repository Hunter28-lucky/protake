package defpackage;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnEvent.java */
/* renamed from: ஊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4456<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f15336;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5246<? super T, ? super Throwable> f15337;

    /* compiled from: SingleDoOnEvent.java */
    /* renamed from: ஊ$Ϳ, reason: contains not printable characters */
    public final class C4457 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f15338;

        public C4457(InterfaceC4782<? super T> interfaceC4782) {
            this.f15338 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            try {
                C4456.this.f15337.accept(null, th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                th = new CompositeException(th, th2);
            }
            this.f15338.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15338.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                C4456.this.f15337.accept(t, null);
                this.f15338.onSuccess(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15338.onError(th);
            }
        }
    }

    public C4456(InterfaceC3951<T> interfaceC3951, InterfaceC5246<? super T, ? super Throwable> interfaceC5246) {
        this.f15336 = interfaceC3951;
        this.f15337 = interfaceC5246;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f15336.subscribe(new C4457(interfaceC4782));
    }
}
