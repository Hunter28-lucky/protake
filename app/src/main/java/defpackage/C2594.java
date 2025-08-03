package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAny.java */
/* renamed from: ɧ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2594<T> extends AbstractC3414<T, Boolean> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f9656;

    /* compiled from: ObservableAny.java */
    /* renamed from: ɧ$Ϳ, reason: contains not printable characters */
    public static final class C2595<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super Boolean> f9657;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f9658;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f9659;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f9660;

        public C2595(InterfaceC5102<? super Boolean> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            this.f9657 = interfaceC5102;
            this.f9658 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f9659.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f9659.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f9660) {
                return;
            }
            this.f9660 = true;
            this.f9657.onNext(Boolean.FALSE);
            this.f9657.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f9660) {
                C3671.m11803(th);
            } else {
                this.f9660 = true;
                this.f9657.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f9660) {
                return;
            }
            try {
                if (this.f9658.test(t)) {
                    this.f9660 = true;
                    this.f9659.dispose();
                    this.f9657.onNext(Boolean.TRUE);
                    this.f9657.onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f9659.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f9659, interfaceC4478)) {
                this.f9659 = interfaceC4478;
                this.f9657.onSubscribe(this);
            }
        }
    }

    public C2594(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f9656 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Boolean> interfaceC5102) {
        this.f11778.subscribe(new C2595(interfaceC5102, this.f9656));
    }
}
