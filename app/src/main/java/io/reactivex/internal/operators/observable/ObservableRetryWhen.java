package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4217;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.k0;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableRetryWhen<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super AbstractC4262<Throwable>, ? extends InterfaceC2856<?>> f7457;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 802743776666017014L;
        public volatile boolean active;
        public final InterfaceC5102<? super T> downstream;
        public final k0<Throwable> signaller;
        public final InterfaceC2856<T> source;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicThrowable error = new AtomicThrowable();
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public final class InnerRepeatObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                RepeatWhenObserver.this.m6881();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                RepeatWhenObserver.this.m6882(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(Object obj) {
                RepeatWhenObserver.this.m6883();
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public RepeatWhenObserver(InterfaceC5102<? super T> interfaceC5102, k0<Throwable> k0Var, InterfaceC2856<T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.signaller = k0Var;
            this.source = interfaceC2856;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            C4217.m13296(this.downstream, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            C4217.m13300(this.downstream, t, this, this.error);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6881() {
            DisposableHelper.dispose(this.upstream);
            C4217.m13296(this.downstream, this, this.error);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6882(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            C4217.m13298(this.downstream, th, this, this.error);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6883() {
            m6884();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6884() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super AbstractC4262<Throwable>, ? extends InterfaceC2856<?>> interfaceC2368) {
        super(interfaceC2856);
        this.f7457 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        k0<T> k0VarM7171 = PublishSubject.m7034().m7171();
        try {
            InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f7457.apply(k0VarM7171), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(interfaceC5102, k0VarM7171, this.f11778);
            interfaceC5102.onSubscribe(repeatWhenObserver);
            interfaceC2856.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.m6884();
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
