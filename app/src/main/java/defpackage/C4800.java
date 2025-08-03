package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: SingleHide.java */
/* renamed from: ඟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4800<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f16274;

    /* compiled from: SingleHide.java */
    /* renamed from: ඟ$Ϳ, reason: contains not printable characters */
    public static final class C4801<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16275;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16276;

        public C4801(InterfaceC4782<? super T> interfaceC4782) {
            this.f16275 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16276.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16276.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f16275.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16276, interfaceC4478)) {
                this.f16276 = interfaceC4478;
                this.f16275.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f16275.onSuccess(t);
        }
    }

    public C4800(InterfaceC3951<? extends T> interfaceC3951) {
        this.f16274 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16274.subscribe(new C4801(interfaceC4782));
    }
}
