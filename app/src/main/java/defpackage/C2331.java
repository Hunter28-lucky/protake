package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkipWhile.java */
/* renamed from: Ģ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2331<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f8859;

    /* compiled from: ObservableSkipWhile.java */
    /* renamed from: Ģ$Ϳ, reason: contains not printable characters */
    public static final class C2332<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f8860;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f8861;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f8862;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f8863;

        public C2332(InterfaceC5102<? super T> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            this.f8860 = interfaceC5102;
            this.f8861 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f8862.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f8862.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f8860.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f8860.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f8863) {
                this.f8860.onNext(t);
                return;
            }
            try {
                if (this.f8861.test(t)) {
                    return;
                }
                this.f8863 = true;
                this.f8860.onNext(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f8862.dispose();
                this.f8860.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f8862, interfaceC4478)) {
                this.f8862 = interfaceC4478;
                this.f8860.onSubscribe(this);
            }
        }
    }

    public C2331(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f8859 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C2332(interfaceC5102, this.f8859));
    }
}
