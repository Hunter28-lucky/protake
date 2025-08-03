package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableCountSingle.java */
/* renamed from: ప, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4544<T> extends AbstractC4838<Long> implements InterfaceC2325<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15563;

    /* compiled from: ObservableCountSingle.java */
    /* renamed from: ప$Ϳ, reason: contains not printable characters */
    public static final class C4545 implements InterfaceC5102<Object>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Long> f15564;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15565;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f15566;

        public C4545(InterfaceC4782<? super Long> interfaceC4782) {
            this.f15564 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15565.dispose();
            this.f15565 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15565.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15565 = DisposableHelper.DISPOSED;
            this.f15564.onSuccess(Long.valueOf(this.f15566));
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15565 = DisposableHelper.DISPOSED;
            this.f15564.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            this.f15566++;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15565, interfaceC4478)) {
                this.f15565 = interfaceC4478;
                this.f15564.onSubscribe(this);
            }
        }
    }

    public C4544(InterfaceC2856<T> interfaceC2856) {
        this.f15563 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Long> interfaceC4782) {
        this.f15563.subscribe(new C4545(interfaceC4782));
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<Long> mo6779() {
        return C3671.m11798(new C4835(this.f15563));
    }
}
