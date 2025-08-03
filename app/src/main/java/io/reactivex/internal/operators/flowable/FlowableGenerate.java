package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3487;
import defpackage.InterfaceC5247;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGenerate<T, S> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<S> f6951;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<S, InterfaceC3487<T>, S> f6952;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super S> f6953;

    public static final class GeneratorSubscription<T, S> extends AtomicLong implements InterfaceC3487<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        public volatile boolean cancelled;
        public final InterfaceC2857<? super S> disposeState;
        public final Subscriber<? super T> downstream;
        public final InterfaceC5247<S, ? super InterfaceC3487<T>, S> generator;
        public boolean hasNext;
        public S state;
        public boolean terminate;

        public GeneratorSubscription(Subscriber<? super T> subscriber, InterfaceC5247<S, ? super InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857, S s) {
            this.downstream = subscriber;
            this.generator = interfaceC5247;
            this.disposeState = interfaceC2857;
            this.state = s;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (C5153.m15069(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                m6466(s);
            }
        }

        @Override // defpackage.InterfaceC3487
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC3487
        public void onError(Throwable th) {
            if (this.terminate) {
                C3671.m11803(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        
            r9.state = r0;
            r10 = addAndGet(-r4);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = defpackage.C5153.m15069(r9, r10)
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                Ⴭ<S, ? super و<T>, S> r1 = r9.generator
            L16:
                r4 = r2
            L17:
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 == 0) goto L4d
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L26
                r9.state = r7
                r9.m6466(r0)
                return
            L26:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3e
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3a
                r9.cancelled = r6
                r9.state = r7
                r9.m6466(r0)
                return
            L3a:
                r6 = 1
                long r4 = r4 + r6
                goto L17
            L3e:
                r10 = move-exception
                defpackage.C4089.m13026(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.m6466(r0)
                return
            L4d:
                long r10 = r9.get()
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 != 0) goto L17
                r9.state = r0
                long r10 = -r4
                long r10 = r9.addAndGet(r10)
                int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                if (r4 != 0) goto L16
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m6466(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }
    }

    public FlowableGenerate(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857) {
        this.f6951 = callable;
        this.f6952 = interfaceC5247;
        this.f6953 = interfaceC2857;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.f6952, this.f6953, this.f6951.call()));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
