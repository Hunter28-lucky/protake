package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletable<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f6934;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6935;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f6936;

    public static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements InterfaceC3899<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final Subscriber<? super T> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;
        public final int maxConcurrency;
        public Subscription upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final C2527 set = new C2527();

        public final class InnerConsumer extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerConsumer() {
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.m6442(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.m6443(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            this.maxConcurrency = i;
            lazySet(1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
            } else {
                Throwable thM7019 = this.errors.m7019();
                if (thM7019 != null) {
                    this.downstream.onError(thM7019);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                cancel();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.m7019());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.m7019());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (this.cancelled || !this.set.mo9333(innerConsumer)) {
                    return;
                }
                interfaceC2837.mo10180(innerConsumer);
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

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return i & 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6442(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.set.mo9335(innerConsumer);
            onComplete();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6443(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
            this.set.mo9335(innerConsumer);
            onError(th);
        }
    }

    public FlowableFlatMapCompletable(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
        super(abstractC3630);
        this.f6934 = interfaceC2368;
        this.f6936 = z;
        this.f6935 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new FlatMapCompletableMainSubscriber(subscriber, this.f6934, this.f6936, this.f6935));
    }
}
