package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C4056;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableThrottleFirstTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7152;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7153;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7154;

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public volatile boolean gate;
        public final long timeout;
        public final SequentialDisposable timer = new SequentialDisposable();
        public final TimeUnit unit;
        public Subscription upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done || this.gate) {
                return;
            }
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            } else {
                this.downstream.onNext(t);
                C5153.m15073(this, 1L);
                InterfaceC4478 interfaceC4478 = this.timer.get();
                if (interfaceC4478 != null) {
                    interfaceC4478.dispose();
                }
                this.timer.m6311(this.worker.mo6991(this, this.timeout, this.unit));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public FlowableThrottleFirstTimed(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(abstractC3630);
        this.f7152 = j;
        this.f7153 = timeUnit;
        this.f7154 = abstractC4585;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new DebounceTimedSubscriber(new C4056(subscriber), this.f7152, this.f7153, this.f7154.mo6986()));
    }
}
