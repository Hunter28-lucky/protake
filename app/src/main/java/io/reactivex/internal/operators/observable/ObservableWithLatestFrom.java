package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5312;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5247;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<? super T, ? super U, ? extends R> f7547;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends U> f7548;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -312246233408980075L;
        public final InterfaceC5247<? super T, ? super U, ? extends R> combiner;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();
        public final AtomicReference<InterfaceC4478> other = new AtomicReference<>();

        public WithLatestFromObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
            this.downstream = interfaceC5102;
            this.combiner = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(C4246.m13353(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    C4089.m13026(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6931(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6932(InterfaceC4478 interfaceC4478) {
            return DisposableHelper.setOnce(this.other, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableWithLatestFrom$Ϳ, reason: contains not printable characters */
    public final class C2102 implements InterfaceC5102<U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final WithLatestFromObserver<T, U, R> f7549;

        public C2102(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f7549 = withLatestFromObserver;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7549.m6931(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(U u) {
            this.f7549.lazySet(u);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f7549.m6932(interfaceC4478);
        }
    }

    public ObservableWithLatestFrom(InterfaceC2856<T> interfaceC2856, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, InterfaceC2856<? extends U> interfaceC28562) {
        super(interfaceC2856);
        this.f7547 = interfaceC5247;
        this.f7548 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        C5312 c5312 = new C5312(interfaceC5102);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(c5312, this.f7547);
        c5312.onSubscribe(withLatestFromObserver);
        this.f7548.subscribe(new C2102(withLatestFromObserver));
        this.f11778.subscribe(withLatestFromObserver);
    }
}
