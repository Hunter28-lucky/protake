package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableLastMaybe.java */
/* renamed from: ජ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4804<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16280;

    /* compiled from: ObservableLastMaybe.java */
    /* renamed from: ජ$Ϳ, reason: contains not printable characters */
    public static final class C4805<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f16281;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16282;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f16283;

        public C4805(InterfaceC5216<? super T> interfaceC5216) {
            this.f16281 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16282.dispose();
            this.f16282 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16282 == DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f16282 = DisposableHelper.DISPOSED;
            T t = this.f16283;
            if (t == null) {
                this.f16281.onComplete();
            } else {
                this.f16283 = null;
                this.f16281.onSuccess(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f16282 = DisposableHelper.DISPOSED;
            this.f16283 = null;
            this.f16281.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f16283 = t;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16282, interfaceC4478)) {
                this.f16282 = interfaceC4478;
                this.f16281.onSubscribe(this);
            }
        }
    }

    public C4804(InterfaceC2856<T> interfaceC2856) {
        this.f16280 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f16280.subscribe(new C4805(interfaceC5216));
    }
}
