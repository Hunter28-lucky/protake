package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2399;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundary<T, B> extends AbstractC3232<T, AbstractC3630<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<B> f7183;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7184;

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Object f7185 = new Object();
        public final int capacityHint;
        public volatile boolean done;
        public final Subscriber<? super AbstractC3630<T>> downstream;
        public long emitted;
        public UnicastProcessor<T> window;
        public final C2060<T, B> boundarySubscriber = new C2060<>(this);
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();

        public WindowBoundaryMainSubscriber(Subscriber<? super AbstractC3630<T>> subscriber, int i) {
            this.downstream = subscriber;
            this.capacityHint = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundarySubscriber.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.upstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.boundarySubscriber.dispose();
            this.done = true;
            m6654();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.boundarySubscriber.dispose();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6654();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.queue.offer(t);
            m6654();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.upstream, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15069(this.requested, j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.upstream);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6654() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super AbstractC3630<T>> subscriber = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            long j = this.emitted;
            int iAddAndGet = 1;
            while (this.windows.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.window;
                boolean z = this.done;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thM7019 = atomicThrowable.m7019();
                    if (unicastProcessor != 0) {
                        this.window = null;
                        unicastProcessor.onError(thM7019);
                    }
                    subscriber.onError(thM7019);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    Throwable thM70192 = atomicThrowable.m7019();
                    if (thM70192 == null) {
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                        return;
                    }
                    if (unicastProcessor != 0) {
                        this.window = null;
                        unicastProcessor.onError(thM70192);
                    }
                    subscriber.onError(thM70192);
                    return;
                }
                if (z2) {
                    this.emitted = j;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f7185) {
                    unicastProcessor.onNext(objPoll);
                } else {
                    if (unicastProcessor != 0) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastProcessor<T> unicastProcessorM7028 = UnicastProcessor.m7028(this.capacityHint, this);
                        this.window = unicastProcessorM7028;
                        this.windows.getAndIncrement();
                        if (j != this.requested.get()) {
                            j++;
                            subscriber.onNext(unicastProcessorM7028);
                        } else {
                            SubscriptionHelper.cancel(this.upstream);
                            this.boundarySubscriber.dispose();
                            atomicThrowable.m7018(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6655() {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            m6654();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6656(Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6654();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6657() {
            this.queue.offer(f7185);
            m6654();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWindowBoundary$Ϳ, reason: contains not printable characters */
    public static final class C2060<T, B> extends AbstractC2399<B> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final WindowBoundaryMainSubscriber<T, B> f7186;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f7187;

        public C2060(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f7186 = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f7187) {
                return;
            }
            this.f7187 = true;
            this.f7186.m6655();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f7187) {
                C3671.m11803(th);
            } else {
                this.f7187 = true;
                this.f7186.m6656(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.f7187) {
                return;
            }
            this.f7186.m6657();
        }
    }

    public FlowableWindowBoundary(AbstractC3630<T> abstractC3630, Publisher<B> publisher, int i) {
        super(abstractC3630);
        this.f7183 = publisher;
        this.f7184 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC3630<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.f7184);
        subscriber.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.m6657();
        this.f7183.subscribe(windowBoundaryMainSubscriber.boundarySubscriber);
        this.f11385.subscribe((InterfaceC3899) windowBoundaryMainSubscriber);
    }
}
