package defpackage;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnError.java */
/* renamed from: ဣ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5133<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f17047;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super Throwable> f17048;

    /* compiled from: SingleDoOnError.java */
    /* renamed from: ဣ$Ϳ, reason: contains not printable characters */
    public final class C5134 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f17049;

        public C5134(InterfaceC4782<? super T> interfaceC4782) {
            this.f17049 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            try {
                C5133.this.f17048.accept(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                th = new CompositeException(th, th2);
            }
            this.f17049.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f17049.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f17049.onSuccess(t);
        }
    }

    public C5133(InterfaceC3951<T> interfaceC3951, InterfaceC2857<? super Throwable> interfaceC2857) {
        this.f17047 = interfaceC3951;
        this.f17048 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f17047.subscribe(new C5134(interfaceC4782));
    }
}
