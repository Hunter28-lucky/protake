package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2930;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMap<T, U> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends U>> f6928;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f6929;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6930;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f6931;

    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements InterfaceC3899<U>, InterfaceC4478 {
        private static final long serialVersionUID = -4606175640614850599L;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;
        public final long id;
        public final int limit;
        public final MergeSubscriber<T, U> parent;
        public long produced;
        public volatile InterfaceC4851<U> queue;

        public InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.id = j;
            this.parent = mergeSubscriber;
            int i = mergeSubscriber.bufferSize;
            this.bufferSize = i;
            this.limit = i >> 2;
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
            this.done = true;
            this.parent.m6434();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.m6438(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.m6440(u, this);
            } else {
                this.parent.m6434();
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.parent.m6434();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC2968;
                    }
                }
                subscription.request(this.bufferSize);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6429(long j) {
            if (this.fusionMode != 1) {
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

    public static final class MergeSubscriber<T, U> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerSubscriber<?, ?>[] f6932 = new InnerSubscriber[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerSubscriber<?, ?>[] f6933 = new InnerSubscriber[0];
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super U> downstream;
        public final AtomicThrowable errs = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final InterfaceC2368<? super T, ? extends Publisher<? extends U>> mapper;
        public final int maxConcurrency;
        public volatile InterfaceC2475<U> queue;
        public final AtomicLong requested;
        public int scalarEmitted;
        public final int scalarLimit;
        public final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        public long uniqueId;
        public Subscription upstream;

        public MergeSubscriber(Subscriber<? super U> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, boolean z, int i, int i2) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            atomicReference.lazySet(f6932);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            InterfaceC2475<U> interfaceC2475;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            m6433();
            if (getAndIncrement() != 0 || (interfaceC2475 = this.queue) == null) {
                return;
            }
            interfaceC2475.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6434();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            if (!this.errs.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            if (!this.delayErrors) {
                for (InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(f6933)) {
                    innerSubscriber.dispose();
                }
            }
            m6434();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    if (m6430(innerSubscriber)) {
                        publisher.subscribe(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) publisher).call();
                    if (objCall != null) {
                        m6441(objCall);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i = this.scalarEmitted + 1;
                    this.scalarEmitted = i;
                    int i2 = this.scalarLimit;
                    if (i == i2) {
                        this.scalarEmitted = 0;
                        this.upstream.request(i2);
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.errs.m7018(th);
                    m6434();
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
                if (this.cancelled) {
                    return;
                }
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6434();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6430(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == f6933) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!C4905.m14631(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6431() {
            if (this.cancelled) {
                m6432();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            m6432();
            Throwable thM7019 = this.errs.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            return true;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6432() {
            InterfaceC2475<U> interfaceC2475 = this.queue;
            if (interfaceC2475 != null) {
                interfaceC2475.clear();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6433() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = f6933;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == innerSubscriberArr2) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable thM7019 = this.errs.m7019();
            if (thM7019 == null || thM7019 == ExceptionHelper.f7687) {
                return;
            }
            C3671.m11803(thM7019);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6434() {
            if (getAndIncrement() == 0) {
                m6435();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6435() {
            long j;
            long j2;
            boolean z;
            int i;
            int i2;
            long j3;
            Object obj;
            Subscriber<? super U> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!m6431()) {
                InterfaceC2475<U> interfaceC2475 = this.queue;
                long jAddAndGet = this.requested.get();
                boolean z2 = jAddAndGet == Long.MAX_VALUE;
                long j4 = 0;
                long j5 = 0;
                if (interfaceC2475 != null) {
                    do {
                        long j6 = 0;
                        obj = null;
                        while (true) {
                            if (jAddAndGet == 0) {
                                break;
                            }
                            U uPoll = interfaceC2475.poll();
                            if (m6431()) {
                                return;
                            }
                            if (uPoll == null) {
                                obj = uPoll;
                                break;
                            }
                            subscriber.onNext(uPoll);
                            j5++;
                            j6++;
                            jAddAndGet--;
                            obj = uPoll;
                        }
                        if (j6 != 0) {
                            jAddAndGet = z2 ? Long.MAX_VALUE : this.requested.addAndGet(-j6);
                        }
                        if (jAddAndGet == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z3 = this.done;
                InterfaceC2475<U> interfaceC24752 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (z3 && ((interfaceC24752 == null || interfaceC24752.isEmpty()) && length == 0)) {
                    Throwable thM7019 = this.errs.m7019();
                    if (thM7019 != ExceptionHelper.f7687) {
                        if (thM7019 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(thM7019);
                            return;
                        }
                    }
                    return;
                }
                int i3 = iAddAndGet;
                if (length != 0) {
                    long j7 = this.lastId;
                    int i4 = this.lastIndex;
                    if (length <= i4 || innerSubscriberArr[i4].id != j7) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        for (int i5 = 0; i5 < length && innerSubscriberArr[i4].id != j7; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr[i4].id;
                    }
                    int i6 = i4;
                    boolean z4 = false;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            z = z4;
                            break;
                        }
                        if (m6431()) {
                            return;
                        }
                        InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr[i6];
                        Object obj2 = null;
                        while (!m6431()) {
                            InterfaceC4851<U> interfaceC4851 = innerSubscriber.queue;
                            if (interfaceC4851 == null) {
                                i = length;
                            } else {
                                i = length;
                                Object obj3 = obj2;
                                long j8 = j4;
                                while (true) {
                                    if (jAddAndGet == j4) {
                                        break;
                                    }
                                    try {
                                        U uPoll2 = interfaceC4851.poll();
                                        if (uPoll2 == null) {
                                            obj3 = uPoll2;
                                            j4 = 0;
                                            break;
                                        }
                                        subscriber.onNext(uPoll2);
                                        if (m6431()) {
                                            return;
                                        }
                                        jAddAndGet--;
                                        j8++;
                                        obj3 = uPoll2;
                                        j4 = 0;
                                    } catch (Throwable th) {
                                        C4089.m13026(th);
                                        innerSubscriber.dispose();
                                        this.errs.m7018(th);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (m6431()) {
                                            return;
                                        }
                                        m6439(innerSubscriber);
                                        i7++;
                                        z4 = true;
                                        i2 = 1;
                                    }
                                }
                                if (j8 != j4) {
                                    jAddAndGet = !z2 ? this.requested.addAndGet(-j8) : Long.MAX_VALUE;
                                    innerSubscriber.m6429(j8);
                                    j3 = 0;
                                } else {
                                    j3 = j4;
                                }
                                if (jAddAndGet != j3 && obj3 != null) {
                                    length = i;
                                    obj2 = obj3;
                                    j4 = 0;
                                }
                            }
                            boolean z5 = innerSubscriber.done;
                            InterfaceC4851<U> interfaceC48512 = innerSubscriber.queue;
                            if (z5 && (interfaceC48512 == null || interfaceC48512.isEmpty())) {
                                m6439(innerSubscriber);
                                if (m6431()) {
                                    return;
                                }
                                j5++;
                                z4 = true;
                            }
                            if (jAddAndGet == 0) {
                                z = z4;
                                break;
                            }
                            i6++;
                            if (i6 == i) {
                                i6 = 0;
                            }
                            i2 = 1;
                            i7 += i2;
                            length = i;
                            j4 = 0;
                        }
                        return;
                    }
                    this.lastIndex = i6;
                    this.lastId = innerSubscriberArr[i6].id;
                    j2 = j5;
                    j = 0;
                } else {
                    j = 0;
                    j2 = j5;
                    z = false;
                }
                if (j2 != j && !this.cancelled) {
                    this.upstream.request(j2);
                }
                if (z) {
                    iAddAndGet = i3;
                } else {
                    iAddAndGet = addAndGet(-i3);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4851<U> m6436(InnerSubscriber<T, U> innerSubscriber) {
            InterfaceC4851<U> interfaceC4851 = innerSubscriber.queue;
            if (interfaceC4851 != null) {
                return interfaceC4851;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4851<U> m6437() {
            InterfaceC2475<U> dVar = this.queue;
            if (dVar == null) {
                dVar = this.maxConcurrency == Integer.MAX_VALUE ? new d<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                this.queue = dVar;
            }
            return dVar;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m6438(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (!this.errs.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            innerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(f6933)) {
                    innerSubscriber2.dispose();
                }
            }
            m6434();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ֈ, reason: contains not printable characters */
        public void m6439(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2] == innerSubscriber) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f6932;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!C4905.m14631(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public void m6440(U u, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                InterfaceC4851<U> interfaceC4851M6436 = innerSubscriber.queue;
                if (j == 0 || !(interfaceC4851M6436 == null || interfaceC4851M6436.isEmpty())) {
                    if (interfaceC4851M6436 == null) {
                        interfaceC4851M6436 = m6436(innerSubscriber);
                    }
                    if (!interfaceC4851M6436.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.m6429(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                InterfaceC4851 spscArrayQueue = innerSubscriber.queue;
                if (spscArrayQueue == null) {
                    spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = spscArrayQueue;
                }
                if (!spscArrayQueue.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6435();
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public void m6441(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                InterfaceC4851<U> interfaceC4851M6437 = this.queue;
                if (j == 0 || !(interfaceC4851M6437 == null || interfaceC4851M6437.isEmpty())) {
                    if (interfaceC4851M6437 == null) {
                        interfaceC4851M6437 = m6437();
                    }
                    if (!interfaceC4851M6437.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i = this.scalarEmitted + 1;
                        this.scalarEmitted = i;
                        int i2 = this.scalarLimit;
                        if (i == i2) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i2);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!m6437().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            m6435();
        }
    }

    public FlowableFlatMap(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, boolean z, int i, int i2) {
        super(abstractC3630);
        this.f6928 = interfaceC2368;
        this.f6929 = z;
        this.f6930 = i;
        this.f6931 = i2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T, U> InterfaceC3899<T> m6428(Subscriber<? super U> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, boolean z, int i, int i2) {
        return new MergeSubscriber(subscriber, interfaceC2368, z, i, i2);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (C2930.m10333(this.f11385, subscriber, this.f6928)) {
            return;
        }
        this.f11385.subscribe((InterfaceC3899) m6428(subscriber, this.f6928, this.f6929, this.f6930, this.f6931));
    }
}
