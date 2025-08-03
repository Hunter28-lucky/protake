package defpackage;

import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* renamed from: ಅ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4592<T, U> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f15684;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<U> f15685;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* renamed from: ಅ$Ϳ, reason: contains not printable characters */
    public final class C4593 implements InterfaceC5102<U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final SequentialDisposable f15686;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15687;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f15688;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: ಅ$Ϳ$Ϳ, reason: contains not printable characters */
        public final class C4594 implements InterfaceC5102<T> {
            public C4594() {
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                C4593.this.f15687.onComplete();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                C4593.this.f15687.onError(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(T t) {
                C4593.this.f15687.onNext(t);
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                C4593.this.f15686.m6312(interfaceC4478);
            }
        }

        public C4593(SequentialDisposable sequentialDisposable, InterfaceC5102<? super T> interfaceC5102) {
            this.f15686 = sequentialDisposable;
            this.f15687 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15688) {
                return;
            }
            this.f15688 = true;
            C4592.this.f15684.subscribe(new C4594());
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15688) {
                C3671.m11803(th);
            } else {
                this.f15688 = true;
                this.f15687.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(U u) {
            onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15686.m6312(interfaceC4478);
        }
    }

    public C4592(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<U> interfaceC28562) {
        this.f15684 = interfaceC2856;
        this.f15685 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC5102.onSubscribe(sequentialDisposable);
        this.f15685.subscribe(new C4593(sequentialDisposable, interfaceC5102));
    }
}
