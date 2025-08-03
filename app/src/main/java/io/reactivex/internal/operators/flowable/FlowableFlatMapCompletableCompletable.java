package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2900;
import defpackage.AbstractC3630;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2583;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends AbstractC2900 implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f6937;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f6938;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6939;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f6940;

    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, InterfaceC4478 {
        private static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final InterfaceC5053 downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;
        public final int maxConcurrency;
        public Subscription upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final C2527 set = new C2527();

        public final class InnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
            private static final long serialVersionUID = 8606673141535671828L;

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

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.m6445(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.m6446(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public FlatMapCompletableMainSubscriber(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
            this.downstream = interfaceC5053;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            this.maxConcurrency = i;
            lazySet(1);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.set.isDisposed();
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
                dispose();
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
                InnerObserver innerObserver = new InnerObserver();
                if (this.disposed || !this.set.mo9333(innerObserver)) {
                    return;
                }
                interfaceC2837.mo10180(innerObserver);
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

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6445(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.set.mo9335(innerObserver);
            onComplete();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6446(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            this.set.mo9335(innerObserver);
            onError(th);
        }
    }

    public FlowableFlatMapCompletableCompletable(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
        this.f6937 = abstractC3630;
        this.f6938 = interfaceC2368;
        this.f6940 = z;
        this.f6939 = i;
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ, reason: contains not printable characters */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableFlatMapCompletable(this.f6937, this.f6938, this.f6940, this.f6939));
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f6937.subscribe((InterfaceC3899) new FlatMapCompletableMainSubscriber(interfaceC5053, this.f6938, this.f6940, this.f6939));
    }
}
