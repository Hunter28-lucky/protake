package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAll.java */
/* renamed from: ჟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5283<T> extends AbstractC3414<T, Boolean> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f17465;

    /* compiled from: ObservableAll.java */
    /* renamed from: ჟ$Ϳ, reason: contains not printable characters */
    public static final class C5284<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super Boolean> f17466;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f17467;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f17468;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f17469;

        public C5284(InterfaceC5102<? super Boolean> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            this.f17466 = interfaceC5102;
            this.f17467 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f17468.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f17468.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f17469) {
                return;
            }
            this.f17469 = true;
            this.f17466.onNext(Boolean.TRUE);
            this.f17466.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f17469) {
                C3671.m11803(th);
            } else {
                this.f17469 = true;
                this.f17466.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f17469) {
                return;
            }
            try {
                if (this.f17467.test(t)) {
                    return;
                }
                this.f17469 = true;
                this.f17468.dispose();
                this.f17466.onNext(Boolean.FALSE);
                this.f17466.onComplete();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f17468.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f17468, interfaceC4478)) {
                this.f17468 = interfaceC4478;
                this.f17466.onSubscribe(this);
            }
        }
    }

    public C5283(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f17465 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Boolean> interfaceC5102) {
        this.f11778.subscribe(new C5284(interfaceC5102, this.f17465));
    }
}
