package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.d;
import io.reactivex.internal.operators.flowable.C2065;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCombineLatest<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T>[] f6888;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends Publisher<? extends T>> f6889;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f6890;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6891;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f6892;

    public static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        public volatile boolean cancelled;
        public final InterfaceC2368<? super Object[], ? extends R> combiner;
        public int completedSources;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public int nonEmptySources;
        public boolean outputFused;
        public final d<Object> queue;
        public final AtomicLong requested;
        public final CombineLatestInnerSubscriber<T>[] subscribers;

        public CombineLatestCoordinator(Subscriber<? super R> subscriber, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, int i2, boolean z) {
            this.downstream = subscriber;
            this.combiner = interfaceC2368;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new d<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            m6388();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // defpackage.InterfaceC4851
        public R poll() throws Exception {
            Object objPoll = this.queue.poll();
            if (objPoll == null) {
                return null;
            }
            R r = (R) C4246.m13353(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) objPoll).m6397();
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6387();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6387() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                m6391();
            } else {
                m6390();
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            this.outputFused = i2 != 0;
            return i2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6388() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.m6396();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean m6389(boolean z, boolean z2, Subscriber<?> subscriber, d<?> dVar) {
            if (this.cancelled) {
                m6388();
                dVar.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayErrors) {
                if (!z2) {
                    return false;
                }
                m6388();
                Throwable thM7021 = ExceptionHelper.m7021(this.error);
                if (thM7021 == null || thM7021 == ExceptionHelper.f7687) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(thM7021);
                }
                return true;
            }
            Throwable thM70212 = ExceptionHelper.m7021(this.error);
            if (thM70212 != null && thM70212 != ExceptionHelper.f7687) {
                m6388();
                dVar.clear();
                subscriber.onError(thM70212);
                return true;
            }
            if (!z2) {
                return false;
            }
            m6388();
            subscriber.onComplete();
            return true;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6390() {
            Subscriber<? super R> subscriber = this.downstream;
            d<?> dVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object objPoll = dVar.poll();
                    boolean z2 = objPoll == null;
                    if (m6389(z, z2, subscriber, dVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) C4246.m13353(this.combiner.apply((Object[]) dVar.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) objPoll).m6397();
                        j2++;
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        m6388();
                        ExceptionHelper.m7020(this.error, th);
                        subscriber.onError(ExceptionHelper.m7021(this.error));
                        return;
                    }
                }
                if (j2 == j && m6389(this.done, dVar.isEmpty(), subscriber, dVar)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6391() {
            Subscriber<? super R> subscriber = this.downstream;
            d<Object> dVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    dVar.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean zIsEmpty = dVar.isEmpty();
                if (!zIsEmpty) {
                    subscriber.onNext(null);
                }
                if (z && zIsEmpty) {
                    subscriber.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            dVar.clear();
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6392(int i) {
            int i2;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i] != null && (i2 = this.completedSources + 1) != objArr.length) {
                    this.completedSources = i2;
                } else {
                    this.done = true;
                    m6387();
                }
            }
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m6393(int i, Throwable th) {
            if (!ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                if (this.delayErrors) {
                    m6392(i);
                    return;
                }
                m6388();
                this.done = true;
                m6387();
            }
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void m6394(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i2 = this.nonEmptySources;
                if (objArr[i] == null) {
                    i2++;
                    this.nonEmptySources = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    this.queue.m5884(this.subscribers[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i].m6397();
            } else {
                m6387();
            }
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public void m6395(Publisher<? extends T>[] publisherArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                publisherArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }
    }

    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        public final int index;
        public final int limit;
        public final CombineLatestCoordinator<T, ?> parent;
        public final int prefetch;
        public int produced;

        public CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.m6392(this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.m6393(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.parent.m6394(this.index, t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.prefetch);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6396() {
            SubscriptionHelper.cancel(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6397() {
            int i = this.produced + 1;
            if (i != this.limit) {
                this.produced = i;
            } else {
                this.produced = 0;
                get().request(i);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCombineLatest$Ϳ, reason: contains not printable characters */
    public final class C2016 implements InterfaceC2368<T, R> {
        public C2016() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // defpackage.InterfaceC2368
        public R apply(T t) throws Exception {
            return FlowableCombineLatest.this.f6890.apply(new Object[]{t});
        }
    }

    public FlowableCombineLatest(Publisher<? extends T>[] publisherArr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
        this.f6888 = publisherArr;
        this.f6889 = null;
        this.f6890 = interfaceC2368;
        this.f6891 = i;
        this.f6892 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.f6888;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) C4246.m13353(this.f6889.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) C4246.m13353(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        EmptySubscription.error(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4089.m13026(th3);
                EmptySubscription.error(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else {
            if (i == 1) {
                publisherArr[0].subscribe(new C2065.C2067(subscriber, new C2016()));
                return;
            }
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f6890, i, this.f6891, this.f6892);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.m6395(publisherArr, i);
        }
    }

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, boolean z) {
        this.f6888 = null;
        this.f6889 = iterable;
        this.f6890 = interfaceC2368;
        this.f6891 = i;
        this.f6892 = z;
    }
}
