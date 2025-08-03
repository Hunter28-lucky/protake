package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C5153;
import defpackage.InterfaceC4478;
import defpackage.y2;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableInterval extends AbstractC3630<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f6998;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f6999;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7000;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7001;

    public static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public long count;
        public final Subscriber<? super Long> downstream;
        public final AtomicReference<InterfaceC4478> resource = new AtomicReference<>();

        public IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() != DisposableHelper.DISPOSED) {
                if (get() != 0) {
                    Subscriber<? super Long> subscriber = this.downstream;
                    long j = this.count;
                    this.count = j + 1;
                    subscriber.onNext(Long.valueOf(j));
                    C5153.m15073(this, 1L);
                    return;
                }
                this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                DisposableHelper.dispose(this.resource);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6517(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.resource, interfaceC4478);
        }
    }

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f6999 = j;
        this.f7000 = j2;
        this.f7001 = timeUnit;
        this.f6998 = abstractC4585;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.onSubscribe(intervalSubscriber);
        AbstractC4585 abstractC4585 = this.f6998;
        if (!(abstractC4585 instanceof y2)) {
            intervalSubscriber.m6517(abstractC4585.mo6989(intervalSubscriber, this.f6999, this.f7000, this.f7001));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = abstractC4585.mo6986();
        intervalSubscriber.m6517(abstractC4588Mo6986);
        abstractC4588Mo6986.mo11922(intervalSubscriber, this.f6999, this.f7000, this.f7001);
    }
}
