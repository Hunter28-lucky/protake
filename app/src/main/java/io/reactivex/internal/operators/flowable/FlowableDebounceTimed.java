package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C4056;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDebounceTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f6919;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f6920;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f6921;

    public static final class DebounceEmitter<T> extends AtomicReference<InterfaceC4478> implements Runnable, InterfaceC4478 {
        private static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final DebounceTimedSubscriber<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedSubscriber;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            m6421();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6421() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.m6423(this.idx, this.value, this);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6422(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public volatile long index;
        public final long timeout;
        public InterfaceC4478 timer;
        public final TimeUnit unit;
        public Subscription upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            InterfaceC4478 interfaceC4478 = this.timer;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) interfaceC4478;
            if (debounceEmitter != null) {
                debounceEmitter.m6421();
            }
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            InterfaceC4478 interfaceC4478 = this.timer;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            InterfaceC4478 interfaceC4478 = this.timer;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
            this.timer = debounceEmitter;
            debounceEmitter.m6422(this.worker.mo6991(debounceEmitter, this.timeout, this.unit));
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
                C5153.m15069(this, j);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6423(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.index) {
                if (get() == 0) {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                } else {
                    this.downstream.onNext(t);
                    C5153.m15073(this, 1L);
                    debounceEmitter.dispose();
                }
            }
        }
    }

    public FlowableDebounceTimed(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(abstractC3630);
        this.f6919 = j;
        this.f6920 = timeUnit;
        this.f6921 = abstractC4585;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new DebounceTimedSubscriber(new C4056(subscriber), this.f6919, this.f6920, this.f6921.mo6986()));
    }
}
