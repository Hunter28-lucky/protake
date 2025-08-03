package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatArray<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T>[] f6894;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f6895;

    public static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements InterfaceC3899<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        public final boolean delayError;
        public final Subscriber<? super T> downstream;
        public List<Throwable> errors;
        public int index;
        public long produced;
        public final Publisher<? extends T>[] sources;
        public final AtomicInteger wip;

        public ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            super(false);
            this.downstream = subscriber;
            this.sources = publisherArr;
            this.delayError = z;
            this.wip = new AtomicInteger();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.sources;
                int length = publisherArr.length;
                int i = this.index;
                while (i != length) {
                    Publisher<? extends T> publisher = publisherArr[i];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.downstream.onError(nullPointerException);
                            return;
                        }
                        List arrayList = this.errors;
                        if (arrayList == null) {
                            arrayList = new ArrayList((length - i) + 1);
                            this.errors = arrayList;
                        }
                        arrayList.add(nullPointerException);
                        i++;
                    } else {
                        long j = this.produced;
                        if (j != 0) {
                            this.produced = 0L;
                            m7014(j);
                        }
                        publisher.subscribe(this);
                        i++;
                        this.index = i;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list = this.errors;
                if (list == null) {
                    this.downstream.onComplete();
                } else if (list.size() == 1) {
                    this.downstream.onError(list.get(0));
                } else {
                    this.downstream.onError(new CompositeException(list));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.delayError) {
                this.downstream.onError(th);
                return;
            }
            List arrayList = this.errors;
            if (arrayList == null) {
                arrayList = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = arrayList;
            }
            arrayList.add(th);
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            m7015(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.f6894 = publisherArr;
        this.f6895 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f6894, this.f6895, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
