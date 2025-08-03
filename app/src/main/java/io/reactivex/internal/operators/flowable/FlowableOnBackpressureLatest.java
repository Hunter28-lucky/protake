package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractC3232<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public Throwable error;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<T> current = new AtomicReference<>();

        public BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6548();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6548();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.current.lazySet(t);
            m6548();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6548();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6547(boolean z, boolean z2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (m6547(r9, r10, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            defpackage.C5153.m15073(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6548() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                org.reactivestreams.Subscriber<? super T> r0 = r13.downstream
                java.util.concurrent.atomic.AtomicLong r1 = r13.requested
                java.util.concurrent.atomic.AtomicReference<T> r2 = r13.current
                r3 = 1
                r4 = r3
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                r10 = 0
                if (r9 == 0) goto L38
                boolean r9 = r13.done
                r11 = 0
                java.lang.Object r11 = r2.getAndSet(r11)
                if (r11 != 0) goto L26
                r12 = r3
                goto L27
            L26:
                r12 = r10
            L27:
                boolean r9 = r13.m6547(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                return
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.onNext(r11)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r11 = r1.get()
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 != 0) goto L50
                boolean r9 = r13.done
                java.lang.Object r11 = r2.get()
                if (r11 != 0) goto L49
                r10 = r3
            L49:
                boolean r9 = r13.m6547(r9, r10, r0, r2)
                if (r9 == 0) goto L50
                return
            L50:
                int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r5 == 0) goto L57
                defpackage.C5153.m15073(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest.BackpressureLatestSubscriber.m6548():void");
        }
    }

    public FlowableOnBackpressureLatest(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new BackpressureLatestSubscriber(subscriber));
    }
}
