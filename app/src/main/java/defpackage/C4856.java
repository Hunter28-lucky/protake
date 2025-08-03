package defpackage;

/* compiled from: ObservableIgnoreElements.java */
/* renamed from: ෆ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4856<T> extends AbstractC3414<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    /* renamed from: ෆ$Ϳ, reason: contains not printable characters */
    public static final class C4857<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f16378;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16379;

        public C4857(InterfaceC5102<? super T> interfaceC5102) {
            this.f16378 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16379.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16379.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f16378.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f16378.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f16379 = interfaceC4478;
            this.f16378.onSubscribe(this);
        }
    }

    public C4856(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4857(interfaceC5102));
    }
}
