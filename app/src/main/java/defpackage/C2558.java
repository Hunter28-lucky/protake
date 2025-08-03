package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkip.java */
/* renamed from: ɋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2558<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f9556;

    /* compiled from: ObservableSkip.java */
    /* renamed from: ɋ$Ϳ, reason: contains not printable characters */
    public static final class C2559<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f9557;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public long f9558;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f9559;

        public C2559(InterfaceC5102<? super T> interfaceC5102, long j) {
            this.f9557 = interfaceC5102;
            this.f9558 = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f9559.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f9559.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f9557.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f9557.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = this.f9558;
            if (j != 0) {
                this.f9558 = j - 1;
            } else {
                this.f9557.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f9559, interfaceC4478)) {
                this.f9559 = interfaceC4478;
                this.f9557.onSubscribe(this);
            }
        }
    }

    public C2558(InterfaceC2856<T> interfaceC2856, long j) {
        super(interfaceC2856);
        this.f9556 = j;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C2559(interfaceC5102, this.f9556));
    }
}
