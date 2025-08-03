package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableCount.java */
/* renamed from: ප, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4835<T> extends AbstractC3414<T, Long> {

    /* compiled from: ObservableCount.java */
    /* renamed from: ප$Ϳ, reason: contains not printable characters */
    public static final class C4836 implements InterfaceC5102<Object>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super Long> f16342;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16343;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f16344;

        public C4836(InterfaceC5102<? super Long> interfaceC5102) {
            this.f16342 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16343.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16343.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f16342.onNext(Long.valueOf(this.f16344));
            this.f16342.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f16342.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            this.f16344++;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16343, interfaceC4478)) {
                this.f16343 = interfaceC4478;
                this.f16342.onSubscribe(this);
            }
        }
    }

    public C4835(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Long> interfaceC5102) {
        this.f11778.subscribe(new C4836(interfaceC5102));
    }
}
