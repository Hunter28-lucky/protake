package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2697;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDoFinally<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f6924;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements InterfaceC2697<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final InterfaceC2697<? super T> downstream;
        public final InterfaceC3809 onFinally;
        public InterfaceC2968<T> qs;
        public boolean syncFused;
        public Subscription upstream;

        public DoFinallyConditionalSubscriber(InterfaceC2697<? super T> interfaceC2697, InterfaceC3809 interfaceC3809) {
            this.downstream = interfaceC2697;
            this.onFinally = interfaceC3809;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            m6425();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.qs.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            m6425();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
            m6425();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    this.qs = (InterfaceC2968) subscription;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                m6425();
            }
            return tPoll;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            InterfaceC2968<T> interfaceC2968 = this.qs;
            if (interfaceC2968 == null || (i & 4) != 0) {
                return 0;
            }
            int iMo6310 = interfaceC2968.mo6310(i);
            if (iMo6310 != 0) {
                this.syncFused = iMo6310 == 1;
            }
            return iMo6310;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6425() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean mo6426(T t) {
            return this.downstream.mo6426(t);
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements InterfaceC3899<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final Subscriber<? super T> downstream;
        public final InterfaceC3809 onFinally;
        public InterfaceC2968<T> qs;
        public boolean syncFused;
        public Subscription upstream;

        public DoFinallySubscriber(Subscriber<? super T> subscriber, InterfaceC3809 interfaceC3809) {
            this.downstream = subscriber;
            this.onFinally = interfaceC3809;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            m6427();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.qs.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            m6427();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
            m6427();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    this.qs = (InterfaceC2968) subscription;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.qs.poll();
            if (tPoll == null && this.syncFused) {
                m6427();
            }
            return tPoll;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            InterfaceC2968<T> interfaceC2968 = this.qs;
            if (interfaceC2968 == null || (i & 4) != 0) {
                return 0;
            }
            int iMo6310 = interfaceC2968.mo6310(i);
            if (iMo6310 != 0) {
                this.syncFused = iMo6310 == 1;
            }
            return iMo6310;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6427() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public FlowableDoFinally(AbstractC3630<T> abstractC3630, InterfaceC3809 interfaceC3809) {
        super(abstractC3630);
        this.f6924 = interfaceC3809;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new DoFinallyConditionalSubscriber((InterfaceC2697) subscriber, this.f6924));
        } else {
            this.f11385.subscribe((InterfaceC3899) new DoFinallySubscriber(subscriber, this.f6924));
        }
    }
}
