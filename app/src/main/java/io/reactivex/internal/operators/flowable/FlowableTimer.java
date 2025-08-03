package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTimer extends AbstractC3630<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f7170;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7171;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7172;

    public static final class TimerSubscriber extends AtomicReference<InterfaceC4478> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final Subscriber<? super Long> downstream;
        public volatile boolean requested;

        public TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (!this.requested) {
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
                } else {
                    this.downstream.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onComplete();
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6650(InterfaceC4478 interfaceC4478) {
            DisposableHelper.trySet(this, interfaceC4478);
        }
    }

    public FlowableTimer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7171 = j;
        this.f7172 = timeUnit;
        this.f7170 = abstractC4585;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.onSubscribe(timerSubscriber);
        timerSubscriber.m6650(this.f7170.mo6988(timerSubscriber, this.f7171, this.f7172));
    }
}
