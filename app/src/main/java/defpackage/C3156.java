package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableHide.java */
/* renamed from: ԙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3156<T> extends AbstractC3414<T, T> {

    /* compiled from: ObservableHide.java */
    /* renamed from: ԙ$Ϳ, reason: contains not printable characters */
    public static final class C3157<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f11206;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f11207;

        public C3157(InterfaceC5102<? super T> interfaceC5102) {
            this.f11206 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11207.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11207.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f11206.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f11206.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f11206.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f11207, interfaceC4478)) {
                this.f11207 = interfaceC4478;
                this.f11206.onSubscribe(this);
            }
        }
    }

    public C3156(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3157(interfaceC5102));
    }
}
