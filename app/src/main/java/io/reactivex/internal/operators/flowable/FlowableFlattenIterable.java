package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> f6947;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6948;

    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        public volatile boolean cancelled;
        public int consumed;
        public Iterator<? extends R> current;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public int fusionMode;
        public final int limit;
        public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> mapper;
        public final int prefetch;
        public InterfaceC4851<T> queue;
        public Subscription upstream;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368, int i) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6458();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done || !ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6458();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t)) {
                m6458();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(3);
                    if (iMo6310 == 1) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.fusionMode = iMo6310;
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
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T tPoll = this.queue.poll();
                    if (tPoll != null) {
                        it = this.mapper.apply(tPoll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) C4246.m13353(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6458();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0124 A[PHI: r6
          0x0124: PHI (r6v4 java.util.Iterator<? extends R>) = (r6v3 java.util.Iterator<? extends R>), (r6v6 java.util.Iterator<? extends R>) binds: [B:30:0x0080, B:67:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6458() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.m6458():void");
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m6459(boolean z, boolean z2, Subscriber<?> subscriber, InterfaceC4851<?> interfaceC4851) {
            if (this.cancelled) {
                this.current = null;
                interfaceC4851.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                subscriber.onComplete();
                return true;
            }
            Throwable thM7021 = ExceptionHelper.m7021(this.error);
            this.current = null;
            interfaceC4851.clear();
            subscriber.onError(thM7021);
            return true;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6460(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i != this.limit) {
                    this.consumed = i;
                } else {
                    this.consumed = 0;
                    this.upstream.request(i);
                }
            }
        }
    }

    public FlowableFlattenIterable(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368, int i) {
        super(abstractC3630);
        this.f6947 = interfaceC2368;
        this.f6948 = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        AbstractC3630<T> abstractC3630 = this.f11385;
        if (!(abstractC3630 instanceof Callable)) {
            abstractC3630.subscribe((InterfaceC3899) new FlattenIterableSubscriber(subscriber, this.f6947, this.f6948));
            return;
        }
        try {
            Object objCall = ((Callable) abstractC3630).call();
            if (objCall == null) {
                EmptySubscription.complete(subscriber);
                return;
            }
            try {
                FlowableFromIterable.m6463(subscriber, this.f6947.apply(objCall).iterator());
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
