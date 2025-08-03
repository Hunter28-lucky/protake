package defpackage;

/* compiled from: SingleDoOnSuccess.java */
/* renamed from: ක, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4794<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f16266;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f16267;

    /* compiled from: SingleDoOnSuccess.java */
    /* renamed from: ක$Ϳ, reason: contains not printable characters */
    public final class C4795 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16268;

        public C4795(InterfaceC4782<? super T> interfaceC4782) {
            this.f16268 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f16268.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f16268.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                C4794.this.f16267.accept(t);
                this.f16268.onSuccess(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16268.onError(th);
            }
        }
    }

    public C4794(InterfaceC3951<T> interfaceC3951, InterfaceC2857<? super T> interfaceC2857) {
        this.f16266 = interfaceC3951;
        this.f16267 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16266.subscribe(new C4795(interfaceC4782));
    }
}
