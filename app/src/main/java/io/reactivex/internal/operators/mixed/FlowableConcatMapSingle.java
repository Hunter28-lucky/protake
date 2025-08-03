package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMapSingle<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7236;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7237;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ErrorMode f7238;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7239;

    public static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final ErrorMode errorMode;
        public R item;
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;
        public final int prefetch;
        public final InterfaceC2475<T> queue;
        public volatile int state;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapSingleSubscriber<?, R> parent;

            public ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.parent = concatMapSingleSubscriber;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.parent.m6687(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                this.parent.m6688(r);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6689() {
                DisposableHelper.dispose(this);
            }
        }

        public ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, int i, ErrorMode errorMode) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.prefetch = i;
            this.errorMode = errorMode;
            this.queue = new SpscArrayQueue(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.m6689();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6686();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.m6689();
            }
            this.done = true;
            m6686();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                m6686();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15069(this.requested, j);
            m6686();
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            r2.clear();
            r15.item = null;
            r0.onError(r3.m7019());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        
            return;
         */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6686() {
            /*
                r15 = this;
                int r0 = r15.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                org.reactivestreams.Subscriber<? super R> r0 = r15.downstream
                io.reactivex.internal.util.ErrorMode r1 = r15.errorMode
                ǅ<T> r2 = r15.queue
                io.reactivex.internal.util.AtomicThrowable r3 = r15.errors
                java.util.concurrent.atomic.AtomicLong r4 = r15.requested
                int r5 = r15.prefetch
                int r6 = r5 >> 1
                int r5 = r5 - r6
                r6 = 1
                r7 = r6
            L18:
                boolean r8 = r15.cancelled
                r9 = 0
                if (r8 == 0) goto L24
                r2.clear()
                r15.item = r9
                goto Lc0
            L24:
                int r8 = r15.state
                java.lang.Object r10 = r3.get()
                if (r10 == 0) goto L43
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r10) goto L36
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r10) goto L43
                if (r8 != 0) goto L43
            L36:
                r2.clear()
                r15.item = r9
                java.lang.Throwable r1 = r3.m7019()
                r0.onError(r1)
                return
            L43:
                r10 = 0
                if (r8 != 0) goto La3
                boolean r8 = r15.done
                java.lang.Object r9 = r2.poll()
                if (r9 != 0) goto L50
                r11 = r6
                goto L51
            L50:
                r11 = r10
            L51:
                if (r8 == 0) goto L63
                if (r11 == 0) goto L63
                java.lang.Throwable r1 = r3.m7019()
                if (r1 != 0) goto L5f
                r0.onComplete()
                goto L62
            L5f:
                r0.onError(r1)
            L62:
                return
            L63:
                if (r11 == 0) goto L66
                goto Lc0
            L66:
                int r8 = r15.consumed
                int r8 = r8 + r6
                if (r8 != r5) goto L74
                r15.consumed = r10
                org.reactivestreams.Subscription r8 = r15.upstream
                long r10 = (long) r5
                r8.request(r10)
                goto L76
            L74:
                r15.consumed = r8
            L76:
                ō<? super T, ? extends ࡗ<? extends R>> r8 = r15.mapper     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r8 = r8.apply(r9)     // Catch: java.lang.Throwable -> L8c
                java.lang.String r9 = "The mapper returned a null SingleSource"
                java.lang.Object r8 = defpackage.C4246.m13353(r8, r9)     // Catch: java.lang.Throwable -> L8c
                ࡗ r8 = (defpackage.InterfaceC3951) r8     // Catch: java.lang.Throwable -> L8c
                r15.state = r6
                io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver<R> r9 = r15.inner
                r8.subscribe(r9)
                goto Lc0
            L8c:
                r1 = move-exception
                defpackage.C4089.m13026(r1)
                org.reactivestreams.Subscription r4 = r15.upstream
                r4.cancel()
                r2.clear()
                r3.m7018(r1)
                java.lang.Throwable r1 = r3.m7019()
                r0.onError(r1)
                return
            La3:
                r11 = 2
                if (r8 != r11) goto Lc0
                long r11 = r15.emitted
                long r13 = r4.get()
                int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r8 == 0) goto Lc0
                R r8 = r15.item
                r15.item = r9
                r0.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                r15.emitted = r11
                r15.state = r10
                goto L18
            Lc0:
                int r7 = -r7
                int r7 = r15.addAndGet(r7)
                if (r7 != 0) goto L18
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableConcatMapSingle.ConcatMapSingleSubscriber.m6686():void");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6687(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            this.state = 0;
            m6686();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6688(R r) {
            this.item = r;
            this.state = 2;
            m6686();
        }
    }

    public FlowableConcatMapSingle(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, ErrorMode errorMode, int i) {
        this.f7236 = abstractC3630;
        this.f7237 = interfaceC2368;
        this.f7238 = errorMode;
        this.f7239 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7236.subscribe((InterfaceC3899) new ConcatMapSingleSubscriber(subscriber, this.f7237, this.f7239, this.f7238));
    }
}
