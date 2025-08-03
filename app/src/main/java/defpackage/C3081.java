package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeUntilPredicate.java */
/* renamed from: ҵ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3081<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f10953;

    /* compiled from: ObservableTakeUntilPredicate.java */
    /* renamed from: ҵ$Ϳ, reason: contains not printable characters */
    public static final class C3082<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f10954;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f10955;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f10956;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10957;

        public C3082(InterfaceC5102<? super T> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            this.f10954 = interfaceC5102;
            this.f10955 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10956.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10956.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f10957) {
                return;
            }
            this.f10957 = true;
            this.f10954.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f10957) {
                C3671.m11803(th);
            } else {
                this.f10957 = true;
                this.f10954.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f10957) {
                return;
            }
            this.f10954.onNext(t);
            try {
                if (this.f10955.test(t)) {
                    this.f10957 = true;
                    this.f10956.dispose();
                    this.f10954.onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f10956.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f10956, interfaceC4478)) {
                this.f10956 = interfaceC4478;
                this.f10954.onSubscribe(this);
            }
        }
    }

    public C3081(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f10953 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3082(interfaceC5102, this.f10953));
    }
}
