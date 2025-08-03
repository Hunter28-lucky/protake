package defpackage;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnTerminate.java */
/* renamed from: භ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4839<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f16345;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f16346;

    /* compiled from: SingleDoOnTerminate.java */
    /* renamed from: භ$Ϳ, reason: contains not printable characters */
    public final class C4840 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16347;

        public C4840(InterfaceC4782<? super T> interfaceC4782) {
            this.f16347 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            try {
                C4839.this.f16346.run();
            } catch (Throwable th2) {
                C4089.m13026(th2);
                th = new CompositeException(th, th2);
            }
            this.f16347.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f16347.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                C4839.this.f16346.run();
                this.f16347.onSuccess(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16347.onError(th);
            }
        }
    }

    public C4839(InterfaceC3951<T> interfaceC3951, InterfaceC3809 interfaceC3809) {
        this.f16345 = interfaceC3951;
        this.f16346 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16345.subscribe(new C4840(interfaceC4782));
    }
}
