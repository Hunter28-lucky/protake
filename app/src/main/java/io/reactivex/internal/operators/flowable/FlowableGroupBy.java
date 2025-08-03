package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2965;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3899;
import defpackage.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractC3232<T, AbstractC2965<K, V>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends K> f6954;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends V> f6955;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6956;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f6957;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final InterfaceC2368<? super InterfaceC2857<Object>, ? extends Map<K, Object>> f6958;

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<AbstractC2965<K, V>> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Object f6959 = new Object();
        public final int bufferSize;
        public final boolean delayError;
        public boolean done;
        public final Subscriber<? super AbstractC2965<K, V>> downstream;
        public Throwable error;
        public final Queue<C2023<K, V>> evictedGroups;
        public volatile boolean finished;
        public final Map<Object, C2023<K, V>> groups;
        public final InterfaceC2368<? super T, ? extends K> keySelector;
        public boolean outputFused;
        public final d<AbstractC2965<K, V>> queue;
        public Subscription upstream;
        public final InterfaceC2368<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger groupCount = new AtomicInteger(1);

        public GroupBySubscriber(Subscriber<? super AbstractC2965<K, V>> subscriber, InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, int i, boolean z, Map<Object, C2023<K, V>> map, Queue<C2023<K, V>> queue) {
            this.downstream = subscriber;
            this.keySelector = interfaceC2368;
            this.valueSelector = interfaceC23682;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new d<>(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                m6470();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<C2023<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            Queue<C2023<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.finished = true;
            m6467();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            Iterator<C2023<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.groups.clear();
            Queue<C2023<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.error = th;
            this.finished = true;
            m6467();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            d dVar = (d<AbstractC2965<K, V>>) this.queue;
            try {
                K kApply = this.keySelector.apply(t);
                boolean z = false;
                Object obj = kApply != null ? kApply : f6959;
                C2023<K, V> c2023 = this.groups.get(obj);
                C2023 c20232 = c2023;
                if (c2023 == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    C2023 c2023M6480 = C2023.m6480(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, c2023M6480);
                    this.groupCount.getAndIncrement();
                    z = true;
                    c20232 = c2023M6480;
                }
                try {
                    c20232.onNext(C4246.m13353(this.valueSelector.apply(t), "The valueSelector returned null"));
                    m6470();
                    if (z) {
                        dVar.offer(c20232);
                        m6467();
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.upstream.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.bufferSize);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6467();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6467() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                m6471();
            } else {
                m6472();
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6468(K k) {
            if (k == null) {
                k = (K) f6959;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                if (this.outputFused || getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean m6469(boolean z, boolean z2, Subscriber<?> subscriber, d<?> dVar) {
            if (this.cancelled.get()) {
                dVar.clear();
                return true;
            }
            if (this.delayError) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                dVar.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m6470() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    C2023<K, V> c2023Poll = this.evictedGroups.poll();
                    if (c2023Poll == null) {
                        break;
                    }
                    c2023Poll.onComplete();
                    i++;
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6471() {
            Throwable th;
            d<AbstractC2965<K, V>> dVar = this.queue;
            Subscriber<? super AbstractC2965<K, V>> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled.get()) {
                boolean z = this.finished;
                if (z && !this.delayError && (th = this.error) != null) {
                    dVar.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6472() {
            d<AbstractC2965<K, V>> dVar = this.queue;
            Subscriber<? super AbstractC2965<K, V>> subscriber = this.downstream;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.finished;
                    AbstractC2965<K, V> abstractC2965Poll = dVar.poll();
                    boolean z2 = abstractC2965Poll == null;
                    if (m6469(z, z2, subscriber, dVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(abstractC2965Poll);
                    j2++;
                }
                if (j2 == j && m6469(this.finished, dVar.isEmpty(), subscriber, dVar)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.upstream.request(j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // defpackage.InterfaceC4851
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC2965<K, V> poll() {
            return this.queue.poll();
        }
    }

    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public boolean outputFused;
        public final GroupBySubscriber<?, K, T> parent;
        public int produced;
        public final d<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        public final AtomicBoolean once = new AtomicBoolean();

        public State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new d<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.m6468(this.key);
            }
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            if (!this.queue.isEmpty()) {
                return false;
            }
            m6478();
            return true;
        }

        public void onComplete() {
            this.done = true;
            m6474();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6474();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            m6474();
        }

        @Override // defpackage.InterfaceC4851
        public T poll() {
            T tPoll = this.queue.poll();
            if (tPoll != null) {
                this.produced++;
                return tPoll;
            }
            m6478();
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6474();
            }
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            if (!this.once.compareAndSet(false, true)) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            m6474();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6474() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                m6476();
            } else {
                m6477();
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m6475(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6476() {
            Throwable th;
            d<T> dVar = this.queue;
            Subscriber<? super T> subscriber = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        dVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        dVar.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6477() {
            d<T> dVar = this.queue;
            boolean z = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (subscriber != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z2 = this.done;
                        T tPoll = dVar.poll();
                        boolean z3 = tPoll == null;
                        if (m6475(z2, z3, subscriber, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.onNext(tPoll);
                        j2++;
                    }
                    if (j2 == j && m6475(this.done, dVar.isEmpty(), subscriber, z)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.parent.upstream.request(j2);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6478() {
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                this.parent.upstream.request(i);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy$Ϳ, reason: contains not printable characters */
    public static final class C2022<K, V> implements InterfaceC2857<C2023<K, V>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Queue<C2023<K, V>> f6960;

        public C2022(Queue<C2023<K, V>> queue) {
            this.f6960 = queue;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(C2023<K, V> c2023) {
            this.f6960.offer(c2023);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy$Ԩ, reason: contains not printable characters */
    public static final class C2023<K, T> extends AbstractC2965<K, T> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final State<T, K> f6961;

        public C2023(K k, State<T, K> state) {
            super(k);
            this.f6961 = state;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static <T, K> C2023<K, T> m6480(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new C2023<>(k, new State(i, groupBySubscriber, k, z));
        }

        public void onComplete() {
            this.f6961.onComplete();
        }

        public void onError(Throwable th) {
            this.f6961.onError(th);
        }

        public void onNext(T t) {
            this.f6961.onNext(t);
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.f6961.subscribe(subscriber);
        }
    }

    public FlowableGroupBy(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, int i, boolean z, InterfaceC2368<? super InterfaceC2857<Object>, ? extends Map<K, Object>> interfaceC23683) {
        super(abstractC3630);
        this.f6954 = interfaceC2368;
        this.f6955 = interfaceC23682;
        this.f6956 = i;
        this.f6957 = z;
        this.f6958 = interfaceC23683;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC2965<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> mapApply;
        try {
            if (this.f6958 == null) {
                concurrentLinkedQueue = null;
                mapApply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                mapApply = this.f6958.apply(new C2022(concurrentLinkedQueue));
            }
            this.f11385.subscribe((InterfaceC3899) new GroupBySubscriber(subscriber, this.f6954, this.f6955, this.f6956, this.f6957, mapApply, concurrentLinkedQueue));
        } catch (Exception e2) {
            C4089.m13026(e2);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e2);
        }
    }
}
