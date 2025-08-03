package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableZip<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T>[] f7202;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends Publisher<? extends T>> f7203;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f7204;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7205;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7206;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        public volatile boolean cancelled;
        public final Object[] current;
        public final boolean delayErrors;
        public final Subscriber<? super R> downstream;
        public final AtomicThrowable errors;
        public final AtomicLong requested;
        public final ZipSubscriber<T, R>[] subscribers;
        public final InterfaceC2368<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Subscriber<? super R> subscriber, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, int i2, boolean z) {
            this.downstream = subscriber;
            this.zipper = interfaceC2368;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            m6671();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6672();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6671() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6672() {
            boolean z;
            T tPoll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.current;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j != j2) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        m6671();
                        subscriber.onError(this.errors.m7019());
                        return;
                    }
                    boolean z3 = false;
                    for (int i = 0; i < length; i++) {
                        ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i];
                        if (objArr[i] == null) {
                            try {
                                z = zipSubscriber.done;
                                InterfaceC4851<T> interfaceC4851 = zipSubscriber.queue;
                                tPoll = interfaceC4851 != null ? interfaceC4851.poll() : null;
                                z2 = tPoll == null;
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                this.errors.m7018(th);
                                if (!this.delayErrors) {
                                    m6671();
                                    subscriber.onError(this.errors.m7019());
                                    return;
                                }
                            }
                            if (z && z2) {
                                m6671();
                                if (this.errors.get() != null) {
                                    subscriber.onError(this.errors.m7019());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z2) {
                                z3 = true;
                            } else {
                                objArr[i] = tPoll;
                            }
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) C4246.m13353(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                        j2++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        m6671();
                        this.errors.m7018(th2);
                        subscriber.onError(this.errors.m7019());
                        return;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        m6671();
                        subscriber.onError(this.errors.m7019());
                        return;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i2];
                        if (objArr[i2] == null) {
                            try {
                                boolean z4 = zipSubscriber2.done;
                                InterfaceC4851<T> interfaceC48512 = zipSubscriber2.queue;
                                T tPoll2 = interfaceC48512 != null ? interfaceC48512.poll() : null;
                                boolean z5 = tPoll2 == null;
                                if (z4 && z5) {
                                    m6671();
                                    if (this.errors.get() != null) {
                                        subscriber.onError(this.errors.m7019());
                                        return;
                                    } else {
                                        subscriber.onComplete();
                                        return;
                                    }
                                }
                                if (!z5) {
                                    objArr[i2] = tPoll2;
                                }
                            } catch (Throwable th3) {
                                C4089.m13026(th3);
                                this.errors.m7018(th3);
                                if (!this.delayErrors) {
                                    m6671();
                                    subscriber.onError(this.errors.m7019());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j2 != 0) {
                    for (ZipSubscriber<T, R> zipSubscriber3 : zipSubscriberArr) {
                        zipSubscriber3.request(j2);
                    }
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6673(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                zipSubscriber.done = true;
                m6672();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6674(Publisher<? extends T>[] publisherArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                publisherArr[i2].subscribe(zipSubscriberArr[i2]);
            }
        }
    }

    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        public volatile boolean done;
        public final int limit;
        public final ZipCoordinator<T, R> parent;
        public final int prefetch;
        public long produced;
        public InterfaceC4851<T> queue;
        public int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.m6672();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.m6673(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.m6672();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.parent.m6672();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
        this.f7202 = publisherArr;
        this.f7203 = iterable;
        this.f7204 = interfaceC2368;
        this.f7205 = i;
        this.f7206 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.f7202;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.f7203) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.f7204, i, this.f7205, this.f7206);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.m6674(publisherArr, i);
    }
}
