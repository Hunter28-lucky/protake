package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2399;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractC3232<T, AbstractC3630<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends Publisher<B>> f7188;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7189;

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C2061<Object, Object> f7190 = new C2061<>(null);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Object f7191 = new Object();
        public final int capacityHint;
        public volatile boolean done;
        public final Subscriber<? super AbstractC3630<T>> downstream;
        public long emitted;
        public final Callable<? extends Publisher<B>> other;
        public Subscription upstream;
        public UnicastProcessor<T> window;
        public final AtomicReference<C2061<T, B>> boundarySubscriber = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();
        public final AtomicLong requested = new AtomicLong();

        public WindowBoundaryMainSubscriber(Subscriber<? super AbstractC3630<T>> subscriber, int i, Callable<? extends Publisher<B>> callable) {
            this.downstream = subscriber;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                m6658();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            m6658();
            this.done = true;
            m6659();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            m6658();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6659();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.queue.offer(t);
            m6659();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                this.queue.offer(f7191);
                m6659();
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15069(this.requested, j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6658() {
            AtomicReference<C2061<T, B>> atomicReference = this.boundarySubscriber;
            C2061<Object, Object> c2061 = f7190;
            InterfaceC4478 interfaceC4478 = (InterfaceC4478) atomicReference.getAndSet(c2061);
            if (interfaceC4478 == null || interfaceC4478 == c2061) {
                return;
            }
            interfaceC4478.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6659() {
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
                } else if (objPoll != f7191) {
                    unicastProcessor.onNext(objPoll);
                } else {
                    if (unicastProcessor != 0) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        if (j != this.requested.get()) {
                            UnicastProcessor<T> unicastProcessorM7028 = UnicastProcessor.m7028(this.capacityHint, this);
                            this.window = unicastProcessorM7028;
                            this.windows.getAndIncrement();
                            try {
                                Publisher publisher = (Publisher) C4246.m13353(this.other.call(), "The other Callable returned a null Publisher");
                                C2061 c2061 = new C2061(this);
                                if (C4905.m14631(this.boundarySubscriber, null, c2061)) {
                                    publisher.subscribe(c2061);
                                    j++;
                                    subscriber.onNext(unicastProcessorM7028);
                                }
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                atomicThrowable.m7018(th);
                                this.done = true;
                            }
                        } else {
                            this.upstream.cancel();
                            m6658();
                            atomicThrowable.m7018(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6660() {
            this.upstream.cancel();
            this.done = true;
            m6659();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6661(Throwable th) {
            this.upstream.cancel();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6659();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6662(C2061<T, B> c2061) {
            C4905.m14631(this.boundarySubscriber, c2061, null);
            this.queue.offer(f7191);
            m6659();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$Ϳ, reason: contains not printable characters */
    public static final class C2061<T, B> extends AbstractC2399<B> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final WindowBoundaryMainSubscriber<T, B> f7192;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f7193;

        public C2061(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.f7192 = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f7193) {
                return;
            }
            this.f7193 = true;
            this.f7192.m6660();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f7193) {
                C3671.m11803(th);
            } else {
                this.f7193 = true;
                this.f7192.m6661(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.f7193) {
                return;
            }
            this.f7193 = true;
            dispose();
            this.f7192.m6662(this);
        }
    }

    public FlowableWindowBoundarySupplier(AbstractC3630<T> abstractC3630, Callable<? extends Publisher<B>> callable, int i) {
        super(abstractC3630);
        this.f7188 = callable;
        this.f7189 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC3630<T>> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new WindowBoundaryMainSubscriber(subscriber, this.f7189, this.f7188));
    }
}
