package defpackage;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* renamed from: ந, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4475<T> extends AbstractC2900 implements InterfaceC2325<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15376;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* renamed from: ந$Ϳ, reason: contains not printable characters */
    public static final class C4476<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f15377;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15378;

        public C4476(InterfaceC5053 interfaceC5053) {
            this.f15377 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15378.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15378.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15377.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15377.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15378 = interfaceC4478;
            this.f15377.onSubscribe(this);
        }
    }

    public C4475(InterfaceC2856<T> interfaceC2856) {
        this.f15376 = interfaceC2856;
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<T> mo6779() {
        return C3671.m11798(new C4856(this.f15376));
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f15376.subscribe(new C4476(interfaceC5053));
    }
}
