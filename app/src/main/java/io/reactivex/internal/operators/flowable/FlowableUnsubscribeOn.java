package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableUnsubscribeOn<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7174;

    public static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        public final Subscriber<? super T> downstream;
        public final AbstractC4585 scheduler;
        public Subscription upstream;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber$Ϳ, reason: contains not printable characters */
        public final class RunnableC2059 implements Runnable {
            public RunnableC2059() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.upstream.cancel();
            }
        }

        public UnsubscribeSubscriber(Subscriber<? super T> subscriber, AbstractC4585 abstractC4585) {
            this.downstream = subscriber;
            this.scheduler = abstractC4585;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.mo6987(new RunnableC2059());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (get()) {
                C3671.m11803(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableUnsubscribeOn(AbstractC3630<T> abstractC3630, AbstractC4585 abstractC4585) {
        super(abstractC3630);
        this.f7174 = abstractC4585;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new UnsubscribeSubscriber(subscriber, this.f7174));
    }
}
