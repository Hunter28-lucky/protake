package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<U> f6870;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Publisher<? extends Open> f6871;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super Open, ? extends Publisher<? extends Close>> f6872;

    public static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        public final InterfaceC2368<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        public final Publisher<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Subscriber<? super C> downstream;
        public long emitted;
        public long index;
        public final d<C> queue = new d<>(AbstractC3630.bufferSize());
        public final C2527 subscribers = new C2527();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public Map<Long, C> buffers = new LinkedHashMap();
        public final AtomicThrowable errors = new AtomicThrowable();

        public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements InterfaceC3899<Open>, InterfaceC4478 {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            public BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.parent = bufferBoundarySubscriber;
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return get() == SubscriptionHelper.CANCELLED;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.m6383(this);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.m6379(this, th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open open) {
                this.parent.m6382(open);
            }

            @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, InterfaceC2368<? super Open, ? extends Publisher<? extends Close>> interfaceC2368, Callable<C> callable) {
            this.downstream = subscriber;
            this.bufferSupplier = callable;
            this.bufferOpen = publisher;
            this.bufferClose = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscribers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                m6381();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            m6381();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.mo9333(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15069(this.requested, j);
            m6381();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6379(InterfaceC4478 interfaceC4478, Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.mo9335(interfaceC4478);
            onError(th);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6380(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            boolean z;
            this.subscribers.mo9335(bufferCloseSubscriber);
            if (this.subscribers.m9338() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                m6381();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6381() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            Subscriber<? super C> subscriber = this.downstream;
            d<C> dVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        dVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        dVar.clear();
                        subscriber.onError(this.errors.m7019());
                        return;
                    }
                    C cPoll = dVar.poll();
                    boolean z2 = cPoll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        return;
                    } else {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(cPoll);
                        j++;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        dVar.clear();
                        return;
                    }
                    if (this.done) {
                        if (this.errors.get() != null) {
                            dVar.clear();
                            subscriber.onError(this.errors.m7019());
                            return;
                        } else if (dVar.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6382(Open open) {
            try {
                Collection collection = (Collection) C4246.m13353(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) C4246.m13353(this.bufferClose.apply(open), "The bufferClose returned a null Publisher");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                    this.subscribers.mo9333(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                SubscriptionHelper.cancel(this.upstream);
                onError(th);
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6383(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.subscribers.mo9335(bufferOpenSubscriber);
            if (this.subscribers.m9338() == 0) {
                SubscriptionHelper.cancel(this.upstream);
                this.done = true;
                m6381();
            }
        }
    }

    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements InterfaceC3899<Object>, InterfaceC4478 {
        private static final long serialVersionUID = -8498650778633225126L;
        public final long index;
        public final BufferBoundarySubscriber<T, C, ?, ?> parent;

        public BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.parent = bufferBoundarySubscriber;
            this.index = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.m6380(this, this.index);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                C3671.m11803(th);
            } else {
                lazySet(subscriptionHelper);
                this.parent.m6379(this, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.parent.m6380(this, this.index);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(AbstractC3630<T> abstractC3630, Publisher<? extends Open> publisher, InterfaceC2368<? super Open, ? extends Publisher<? extends Close>> interfaceC2368, Callable<U> callable) {
        super(abstractC3630);
        this.f6871 = publisher;
        this.f6872 = interfaceC2368;
        this.f6870 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.f6871, this.f6872, this.f6870);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.f11385.subscribe((InterfaceC3899) bufferBoundarySubscriber);
    }
}
