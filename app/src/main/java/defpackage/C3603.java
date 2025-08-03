package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeFromSingle.java */
/* renamed from: ڴ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3603<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f12530;

    /* compiled from: MaybeFromSingle.java */
    /* renamed from: ڴ$Ϳ, reason: contains not printable characters */
    public static final class C3604<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f12531;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f12532;

        public C3604(InterfaceC5216<? super T> interfaceC5216) {
            this.f12531 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12532.dispose();
            this.f12532 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12532.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f12532 = DisposableHelper.DISPOSED;
            this.f12531.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f12532, interfaceC4478)) {
                this.f12532 = interfaceC4478;
                this.f12531.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f12532 = DisposableHelper.DISPOSED;
            this.f12531.onSuccess(t);
        }
    }

    public C3603(InterfaceC3951<T> interfaceC3951) {
        this.f12530 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f12530.subscribe(new C3604(interfaceC5216));
    }
}
