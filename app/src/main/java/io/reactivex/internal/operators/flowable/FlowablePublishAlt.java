package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3731;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.InterfaceC4851;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowablePublishAlt<T> extends AbstractC3731<T> implements InterfaceC4503 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f7046;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7047;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<PublishConnection<T>> f7048 = new AtomicReference<>();

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        public final Subscriber<? super T> downstream;
        public long emitted;
        public final PublishConnection<T> parent;

        public InnerSubscription(Subscriber<? super T> subscriber, PublishConnection<T> publishConnection) {
            this.downstream = subscriber;
            this.parent = publishConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m6562(this);
                this.parent.m6561();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15070(this, j);
            this.parent.m6561();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6558() {
            return get() == Long.MIN_VALUE;
        }
    }

    public static final class PublishConnection<T> extends AtomicInteger implements InterfaceC3899<T>, InterfaceC4478 {
        private static final long serialVersionUID = -1672047311619175801L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerSubscription[] f7049 = new InnerSubscription[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerSubscription[] f7050 = new InnerSubscription[0];
        public final int bufferSize;
        public int consumed;
        public final AtomicReference<PublishConnection<T>> current;
        public volatile boolean done;
        public Throwable error;
        public volatile InterfaceC4851<T> queue;
        public int sourceMode;
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicBoolean connect = new AtomicBoolean();
        public final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(f7049);

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.subscribers.getAndSet(f7050);
            C4905.m14631(this.current, this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.subscribers.get() == f7050;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6561();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.error = th;
            this.done = true;
            m6561();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                m6561();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        m6561();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6559(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == f7050) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!C4905.m14631(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6560(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                m6563(th);
                return true;
            }
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f7050)) {
                if (!innerSubscription.m6558()) {
                    innerSubscription.downstream.onComplete();
                }
            }
            return true;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6561() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4851<T> interfaceC4851 = this.queue;
            int i = this.consumed;
            int i2 = this.bufferSize;
            int i3 = i2 - (i2 >> 2);
            boolean z = this.sourceMode != 1;
            int iAddAndGet = 1;
            InterfaceC4851<T> interfaceC48512 = interfaceC4851;
            int i4 = i;
            while (true) {
                if (interfaceC48512 != null) {
                    long jMin = Long.MAX_VALUE;
                    InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    boolean z2 = false;
                    for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        long j = innerSubscription.get();
                        if (j != Long.MIN_VALUE) {
                            jMin = Math.min(j - innerSubscription.emitted, jMin);
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        jMin = 0;
                    }
                    for (long j2 = 0; jMin != j2; j2 = 0) {
                        boolean z3 = this.done;
                        try {
                            T tPoll = interfaceC48512.poll();
                            boolean z4 = tPoll == null;
                            if (m6560(z3, z4)) {
                                return;
                            }
                            if (z4) {
                                break;
                            }
                            for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                if (!innerSubscription2.m6558()) {
                                    innerSubscription2.downstream.onNext(tPoll);
                                    innerSubscription2.emitted++;
                                }
                            }
                            if (z && (i4 = i4 + 1) == i3) {
                                this.upstream.get().request(i3);
                                i4 = 0;
                            }
                            jMin--;
                            if (innerSubscriptionArr != this.subscribers.get()) {
                                break;
                            }
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            this.upstream.get().cancel();
                            interfaceC48512.clear();
                            this.done = true;
                            m6563(th);
                            return;
                        }
                    }
                    if (m6560(this.done, interfaceC48512.isEmpty())) {
                        return;
                    }
                }
                this.consumed = i4;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (interfaceC48512 == null) {
                    interfaceC48512 = this.queue;
                }
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6562(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i2] == innerSubscription) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = f7049;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!C4905.m14631(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6563(Throwable th) {
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f7050)) {
                if (!innerSubscription.m6558()) {
                    innerSubscription.downstream.onError(th);
                }
            }
        }
    }

    public FlowablePublishAlt(Publisher<T> publisher, int i) {
        this.f7046 = publisher;
        this.f7047 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f7048.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f7048, this.f7047);
            if (C4905.m14631(this.f7048, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerSubscription<T> innerSubscription = new InnerSubscription<>(subscriber, publishConnection);
        subscriber.onSubscribe(innerSubscription);
        if (publishConnection.m6559(innerSubscription)) {
            if (innerSubscription.m6558()) {
                publishConnection.m6562(innerSubscription);
                return;
            } else {
                publishConnection.m6561();
                return;
            }
        }
        Throwable th = publishConnection.error;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    @Override // defpackage.InterfaceC4503
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo6557(InterfaceC4478 interfaceC4478) {
        C4905.m14631(this.f7048, (PublishConnection) interfaceC4478, null);
    }

    @Override // defpackage.AbstractC3731
    /* renamed from: Ԫ */
    public void mo6552(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f7048.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f7048, this.f7047);
            if (C4905.m14631(this.f7048, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = !publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true);
        try {
            interfaceC2857.accept(publishConnection);
            if (z) {
                this.f7046.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }
}
