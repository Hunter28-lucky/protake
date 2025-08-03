package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC2697;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableObserveOn<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7023;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7024;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7025;

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements InterfaceC3899<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public boolean outputFused;
        public final int prefetch;
        public long produced;
        public InterfaceC4851<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public int sourceMode;
        public Subscription upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public BaseObserveOnSubscriber(AbstractC4585.AbstractC4588 abstractC4588, boolean z, int i) {
            this.worker = abstractC4588;
            this.delayError = z;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public final void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6542();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.error = th;
            this.done = true;
            m6542();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                m6542();
                return;
            }
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            m6542();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6542();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                mo6540();
            } else if (this.sourceMode == 1) {
                mo6541();
            } else {
                mo6539();
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public final int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final boolean m6538(boolean z, boolean z2, Subscriber<?> subscriber) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.cancelled = true;
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.cancelled = true;
                clear();
                subscriber.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            subscriber.onComplete();
            this.worker.dispose();
            return true;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public abstract void mo6539();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public abstract void mo6540();

        /* renamed from: Ԯ, reason: contains not printable characters */
        public abstract void mo6541();

        /* renamed from: ԯ, reason: contains not printable characters */
        public final void m6542() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.mo6990(this);
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        public long consumed;
        public final InterfaceC2697<? super T> downstream;

        public ObserveOnConditionalSubscriber(InterfaceC2697<? super T> interfaceC2697, AbstractC4585.AbstractC4588 abstractC4588, boolean z, int i) {
            super(abstractC4588, z, i);
            this.downstream = interfaceC2697;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = 1;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = 2;
                        this.queue = interfaceC2968;
                        this.downstream.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j = this.consumed + 1;
                if (j == this.limit) {
                    this.consumed = 0L;
                    this.upstream.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return tPoll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: ԫ */
        public void mo6539() {
            InterfaceC2697<? super T> interfaceC2697 = this.downstream;
            InterfaceC4851<T> interfaceC4851 = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j != j3) {
                    boolean z = this.done;
                    try {
                        T tPoll = interfaceC4851.poll();
                        boolean z2 = tPoll == null;
                        if (m6538(z, z2, interfaceC2697)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (interfaceC2697.mo6426(tPoll)) {
                            j++;
                        }
                        j2++;
                        if (j2 == this.limit) {
                            this.upstream.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        interfaceC4851.clear();
                        interfaceC2697.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == j3 && m6538(this.done, interfaceC4851.isEmpty(), interfaceC2697)) {
                    return;
                }
                int i = get();
                if (iAddAndGet == i) {
                    this.produced = j;
                    this.consumed = j2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: Ԭ */
        public void mo6540() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: Ԯ */
        public void mo6541() {
            InterfaceC2697<? super T> interfaceC2697 = this.downstream;
            InterfaceC4851<T> interfaceC4851 = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T tPoll = interfaceC4851.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            interfaceC2697.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (interfaceC2697.mo6426(tPoll)) {
                            j++;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        interfaceC2697.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (interfaceC4851.isEmpty()) {
                    this.cancelled = true;
                    interfaceC2697.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i = get();
                    if (iAddAndGet == i) {
                        this.produced = j;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i;
                    }
                }
            }
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        public final Subscriber<? super T> downstream;

        public ObserveOnSubscriber(Subscriber<? super T> subscriber, AbstractC4585.AbstractC4588 abstractC4588, boolean z, int i) {
            super(abstractC4588, z, i);
            this.downstream = subscriber;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = 1;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = 2;
                        this.queue = interfaceC2968;
                        this.downstream.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j == this.limit) {
                    this.produced = 0L;
                    this.upstream.request(j);
                } else {
                    this.produced = j;
                }
            }
            return tPoll;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: ԫ */
        public void mo6539() {
            Subscriber<? super T> subscriber = this.downstream;
            InterfaceC4851<T> interfaceC4851 = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested.get();
                while (j != jAddAndGet) {
                    boolean z = this.done;
                    try {
                        T tPoll = interfaceC4851.poll();
                        boolean z2 = tPoll == null;
                        if (m6538(z, z2, subscriber)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(tPoll);
                        j++;
                        if (j == this.limit) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.requested.addAndGet(-j);
                            }
                            this.upstream.request(j);
                            j = 0;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        interfaceC4851.clear();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j == jAddAndGet && m6538(this.done, interfaceC4851.isEmpty(), subscriber)) {
                    return;
                }
                int i = get();
                if (iAddAndGet == i) {
                    this.produced = j;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: Ԭ */
        public void mo6540() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /* renamed from: Ԯ */
        public void mo6541() {
            Subscriber<? super T> subscriber = this.downstream;
            InterfaceC4851<T> interfaceC4851 = this.queue;
            long j = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        T tPoll = interfaceC4851.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            subscriber.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        subscriber.onNext(tPoll);
                        j++;
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        subscriber.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (interfaceC4851.isEmpty()) {
                    this.cancelled = true;
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i = get();
                    if (iAddAndGet == i) {
                        this.produced = j;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i;
                    }
                }
            }
        }
    }

    public FlowableObserveOn(AbstractC3630<T> abstractC3630, AbstractC4585 abstractC4585, boolean z, int i) {
        super(abstractC3630);
        this.f7023 = abstractC4585;
        this.f7024 = z;
        this.f7025 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = this.f7023.mo6986();
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new ObserveOnConditionalSubscriber((InterfaceC2697) subscriber, abstractC4588Mo6986, this.f7024, this.f7025));
        } else {
            this.f11385.subscribe((InterfaceC3899) new ObserveOnSubscriber(subscriber, abstractC4588Mo6986, this.f7024, this.f7025));
        }
    }
}
