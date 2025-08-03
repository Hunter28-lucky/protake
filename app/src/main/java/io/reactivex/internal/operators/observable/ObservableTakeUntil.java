package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C4217;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTakeUntil<T, U> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends U> f7505;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 1418547743690811973L;
        public final InterfaceC5102<? super T> downstream;
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();
        public final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class OtherObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5102<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                TakeUntilMainObserver.this.m6911();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                TakeUntilMainObserver.this.m6912(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.m6911();
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public TakeUntilMainObserver(InterfaceC5102<? super T> interfaceC5102) {
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            C4217.m13296(this.downstream, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            C4217.m13298(this.downstream, th, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            C4217.m13300(this.downstream, t, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6911() {
            DisposableHelper.dispose(this.upstream);
            C4217.m13296(this.downstream, this, this.error);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6912(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            C4217.m13298(this.downstream, th, this, this.error);
        }
    }

    public ObservableTakeUntil(InterfaceC2856<T> interfaceC2856, InterfaceC2856<? extends U> interfaceC28562) {
        super(interfaceC2856);
        this.f7505 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(interfaceC5102);
        interfaceC5102.onSubscribe(takeUntilMainObserver);
        this.f7505.subscribe(takeUntilMainObserver.otherObserver);
        this.f11778.subscribe(takeUntilMainObserver);
    }
}
