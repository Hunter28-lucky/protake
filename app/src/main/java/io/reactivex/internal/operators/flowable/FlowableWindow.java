package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import defpackage.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindow<T> extends AbstractC3232<T, AbstractC3630<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7180;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7181;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7182;

    public static final class WindowExactSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        public final int bufferSize;
        public final Subscriber<? super AbstractC3630<T>> downstream;
        public long index;
        public final AtomicBoolean once;
        public final long size;
        public Subscription upstream;
        public UnicastProcessor<T> window;

        public WindowExactSubscriber(Subscriber<? super AbstractC3630<T>> subscriber, long j, int i) {
            super(1);
            this.downstream = subscriber;
            this.size = j;
            this.once = new AtomicBoolean();
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessorM7028 = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessorM7028 = UnicastProcessor.m7028(this.bufferSize, this);
                this.window = unicastProcessorM7028;
                this.downstream.onNext(unicastProcessorM7028);
            }
            long j2 = j + 1;
            unicastProcessorM7028.onNext(t);
            if (j2 != this.size) {
                this.index = j2;
                return;
            }
            this.index = 0L;
            this.window = null;
            unicastProcessorM7028.onComplete();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.upstream.request(C5153.m15072(this.size, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public static final class WindowOverlapSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Subscriber<? super AbstractC3630<T>> downstream;
        public Throwable error;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public long produced;
        public final d<UnicastProcessor<T>> queue;
        public final AtomicLong requested;
        public final long size;
        public final long skip;
        public Subscription upstream;
        public final ArrayDeque<UnicastProcessor<T>> windows;
        public final AtomicInteger wip;

        public WindowOverlapSubscriber(Subscriber<? super AbstractC3630<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.downstream = subscriber;
            this.size = j;
            this.skip = j2;
            this.queue = new d<>(i);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            m6653();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            m6653();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index;
            if (j == 0 && !this.cancelled) {
                getAndIncrement();
                UnicastProcessor<T> unicastProcessorM7028 = UnicastProcessor.m7028(this.bufferSize, this);
                this.windows.offer(unicastProcessorM7028);
                this.queue.offer(unicastProcessorM7028);
                m6653();
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j3 = this.produced + 1;
            if (j3 == this.size) {
                this.produced = j3 - this.skip;
                UnicastProcessor<T> unicastProcessorPoll = this.windows.poll();
                if (unicastProcessorPoll != null) {
                    unicastProcessorPoll.onComplete();
                }
            } else {
                this.produced = j3;
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(C5153.m15072(this.skip, j));
                } else {
                    this.upstream.request(C5153.m15071(this.size, C5153.m15072(this.skip, j - 1)));
                }
                m6653();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6652(boolean z, boolean z2, Subscriber<?> subscriber, d<?> dVar) {
            if (this.cancelled) {
                dVar.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                dVar.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6653() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super AbstractC3630<T>> subscriber = this.downstream;
            d<UnicastProcessor<T>> dVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    UnicastProcessor<T> unicastProcessorPoll = dVar.poll();
                    boolean z2 = unicastProcessorPoll == null;
                    if (m6652(z, z2, subscriber, dVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(unicastProcessorPoll);
                    j2++;
                }
                if (j2 == j && m6652(this.done, dVar.isEmpty(), subscriber, dVar)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    public static final class WindowSkipSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        public final int bufferSize;
        public final Subscriber<? super AbstractC3630<T>> downstream;
        public final AtomicBoolean firstRequest;
        public long index;
        public final AtomicBoolean once;
        public final long size;
        public final long skip;
        public Subscription upstream;
        public UnicastProcessor<T> window;

        public WindowSkipSubscriber(Subscriber<? super AbstractC3630<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.downstream = subscriber;
            this.size = j;
            this.skip = j2;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessorM7028 = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessorM7028 = UnicastProcessor.m7028(this.bufferSize, this);
                this.window = unicastProcessorM7028;
                this.downstream.onNext(unicastProcessorM7028);
            }
            long j2 = j + 1;
            if (unicastProcessorM7028 != null) {
                unicastProcessorM7028.onNext(t);
            }
            if (j2 == this.size) {
                this.window = null;
                unicastProcessorM7028.onComplete();
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.upstream.request(C5153.m15072(this.skip, j));
                } else {
                    this.upstream.request(C5153.m15071(C5153.m15072(this.size, j), C5153.m15072(this.skip - this.size, j - 1)));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    public FlowableWindow(AbstractC3630<T> abstractC3630, long j, long j2, int i) {
        super(abstractC3630);
        this.f7180 = j;
        this.f7181 = j2;
        this.f7182 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC3630<T>> subscriber) {
        long j = this.f7181;
        long j2 = this.f7180;
        if (j == j2) {
            this.f11385.subscribe((InterfaceC3899) new WindowExactSubscriber(subscriber, this.f7180, this.f7182));
        } else if (j > j2) {
            this.f11385.subscribe((InterfaceC3899) new WindowSkipSubscriber(subscriber, this.f7180, this.f7181, this.f7182));
        } else {
            this.f11385.subscribe((InterfaceC3899) new WindowOverlapSubscriber(subscriber, this.f7180, this.f7181, this.f7182));
        }
    }
}
