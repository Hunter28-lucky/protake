package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5216;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> f6941;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f6942;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6943;

    public static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final Subscriber<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> mapper;
        public final int maxConcurrency;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final C2527 set = new C2527();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicInteger active = new AtomicInteger(1);
        public final AtomicReference<d<R>> queue = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5216<R>, InterfaceC4478 {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // defpackage.InterfaceC5216
            public void onComplete() {
                FlatMapMaybeSubscriber.this.m6450(this);
            }

            @Override // defpackage.InterfaceC5216
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.m6451(this, th);
            }

            @Override // defpackage.InterfaceC5216
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC5216
            public void onSuccess(R r) {
                FlatMapMaybeSubscriber.this.m6452(this, r);
            }
        }

        public FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z, int i) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        public void clear() {
            d<R> dVar = this.queue.get();
            if (dVar != null) {
                dVar.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.active.decrementAndGet();
            m6447();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            m6447();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                InterfaceC3517 interfaceC3517 = (InterfaceC3517) C4246.m13353(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.mo9333(innerObserver)) {
                    return;
                }
                interfaceC3517.mo11463(innerObserver);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
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
                m6447();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6447() {
            if (getAndIncrement() == 0) {
                m6448();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        
            r2 = r17.errors.m7019();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        
            if (r13 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
        
            r2 = r17.errors.m7019();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
        
            defpackage.C5153.m15073(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
        
            r17.upstream.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        
            return;
         */
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6448() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.m6448():void");
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public d<R> m6449() {
            d<R> dVar;
            do {
                d<R> dVar2 = this.queue.get();
                if (dVar2 != null) {
                    return dVar2;
                }
                dVar = new d<>(AbstractC3630.bufferSize());
            } while (!C4905.m14631(this.queue, null, dVar));
            return dVar;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6450(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.set.mo9335(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    d<R> dVar = this.queue.get();
                    if (z && (dVar == null || dVar.isEmpty())) {
                        Throwable thM7019 = this.errors.m7019();
                        if (thM7019 != null) {
                            this.downstream.onError(thM7019);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    m6448();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            m6447();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6451(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.mo9335(innerObserver);
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            this.active.decrementAndGet();
            m6447();
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
        /* renamed from: Ԭ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6452(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber<T, R>.InnerObserver r5, R r6) {
            /*
                r4 = this;
                Ȝ r0 = r4.set
                r0.mo9335(r5)
                int r5 = r4.get()
                if (r5 != 0) goto L7a
                r5 = 0
                r0 = 1
                boolean r1 = r4.compareAndSet(r5, r0)
                if (r1 == 0) goto L7a
                java.util.concurrent.atomic.AtomicInteger r1 = r4.active
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                r5 = r0
            L1c:
                java.util.concurrent.atomic.AtomicLong r0 = r4.requested
                long r0 = r0.get()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L67
                org.reactivestreams.Subscriber<? super R> r0 = r4.downstream
                r0.onNext(r6)
                java.util.concurrent.atomic.AtomicReference<d<R>> r6 = r4.queue
                java.lang.Object r6 = r6.get()
                d r6 = (defpackage.d) r6
                if (r5 == 0) goto L53
                if (r6 == 0) goto L3f
                boolean r5 = r6.isEmpty()
                if (r5 == 0) goto L53
            L3f:
                io.reactivex.internal.util.AtomicThrowable r5 = r4.errors
                java.lang.Throwable r5 = r5.m7019()
                if (r5 == 0) goto L4d
                org.reactivestreams.Subscriber<? super R> r6 = r4.downstream
                r6.onError(r5)
                goto L52
            L4d:
                org.reactivestreams.Subscriber<? super R> r5 = r4.downstream
                r5.onComplete()
            L52:
                return
            L53:
                java.util.concurrent.atomic.AtomicLong r5 = r4.requested
                r0 = 1
                defpackage.C5153.m15073(r5, r0)
                int r5 = r4.maxConcurrency
                r6 = 2147483647(0x7fffffff, float:NaN)
                if (r5 == r6) goto L70
                org.reactivestreams.Subscription r5 = r4.upstream
                r5.request(r0)
                goto L70
            L67:
                d r5 = r4.m6449()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            L70:
                int r5 = r4.decrementAndGet()
                if (r5 != 0) goto L8f
                return
            L77:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
                throw r6
            L7a:
                d r5 = r4.m6449()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L93
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                java.util.concurrent.atomic.AtomicInteger r5 = r4.active
                r5.decrementAndGet()
                int r5 = r4.getAndIncrement()
                if (r5 == 0) goto L8f
                return
            L8f:
                r4.m6448()
                return
            L93:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.m6452(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver, java.lang.Object):void");
        }
    }

    public FlowableFlatMapMaybe(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z, int i) {
        super(abstractC3630);
        this.f6941 = interfaceC2368;
        this.f6942 = z;
        this.f6943 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new FlatMapMaybeSubscriber(subscriber, this.f6941, this.f6942, this.f6943));
    }
}
