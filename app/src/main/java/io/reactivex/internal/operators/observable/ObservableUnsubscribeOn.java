package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7527;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 1015244841293359600L;
        public final InterfaceC5102<? super T> downstream;
        public final AbstractC4585 scheduler;
        public InterfaceC4478 upstream;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver$Ϳ, reason: contains not printable characters */
        public final class RunnableC2099 implements Runnable {
            public RunnableC2099() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.upstream.dispose();
            }
        }

        public UnsubscribeObserver(InterfaceC5102<? super T> interfaceC5102, AbstractC4585 abstractC4585) {
            this.downstream = interfaceC5102;
            this.scheduler = abstractC4585;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.mo6987(new RunnableC2099());
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (get()) {
                C3671.m11803(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(InterfaceC2856<T> interfaceC2856, AbstractC4585 abstractC4585) {
        super(interfaceC2856);
        this.f7527 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new UnsubscribeObserver(interfaceC5102, this.f7527));
    }
}
