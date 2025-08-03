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
public final class FlowableIntervalRange extends AbstractC3630<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f7002;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7003;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7004;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final long f7005;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final long f7006;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final TimeUnit f7007;

    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public long count;
        public final Subscriber<? super Long> downstream;
        public final long end;
        public final AtomicReference<InterfaceC4478> resource = new AtomicReference<>();

        public IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j, long j2) {
            this.downstream = subscriber;
            this.count = j;
            this.end = j2;
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
            InterfaceC4478 interfaceC4478 = this.resource.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 != disposableHelper) {
                long j = get();
                if (j == 0) {
                    this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                long j2 = this.count;
                this.downstream.onNext(Long.valueOf(j2));
                if (j2 == this.end) {
                    if (this.resource.get() != disposableHelper) {
                        this.downstream.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                } else {
                    this.count = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6518(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.resource, interfaceC4478);
        }
    }

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7005 = j3;
        this.f7006 = j4;
        this.f7007 = timeUnit;
        this.f7002 = abstractC4585;
        this.f7003 = j;
        this.f7004 = j2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.f7003, this.f7004);
        subscriber.onSubscribe(intervalRangeSubscriber);
        AbstractC4585 abstractC4585 = this.f7002;
        if (!(abstractC4585 instanceof y2)) {
            intervalRangeSubscriber.m6518(abstractC4585.mo6989(intervalRangeSubscriber, this.f7005, this.f7006, this.f7007));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = abstractC4585.mo6986();
        intervalRangeSubscriber.m6518(abstractC4588Mo6986);
        abstractC4588Mo6986.mo11922(intervalRangeSubscriber, this.f7005, this.f7006, this.f7007);
    }
}
