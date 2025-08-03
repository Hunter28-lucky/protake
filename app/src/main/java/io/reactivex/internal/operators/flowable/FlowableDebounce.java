package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2399;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4056;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDebounce<T, U> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<U>> f6913;

    public static final class DebounceSubscriber<T, U> extends AtomicLong implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        public final InterfaceC2368<? super T, ? extends Publisher<U>> debounceSelector;
        public final AtomicReference<InterfaceC4478> debouncer = new AtomicReference<>();
        public boolean done;
        public final Subscriber<? super T> downstream;
        public volatile long index;
        public Subscription upstream;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber$Ϳ, reason: contains not printable characters */
        public static final class C2021<T, U> extends AbstractC2399<U> {

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final DebounceSubscriber<T, U> f6914;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final long f6915;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final T f6916;

            /* renamed from: ԯ, reason: contains not printable characters */
            public boolean f6917;

            /* renamed from: ՠ, reason: contains not printable characters */
            public final AtomicBoolean f6918 = new AtomicBoolean();

            public C2021(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.f6914 = debounceSubscriber;
                this.f6915 = j;
                this.f6916 = t;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.f6917) {
                    return;
                }
                this.f6917 = true;
                m6420();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.f6917) {
                    C3671.m11803(th);
                } else {
                    this.f6917 = true;
                    this.f6914.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u) {
                if (this.f6917) {
                    return;
                }
                this.f6917 = true;
                m8890();
                m6420();
            }

            /* renamed from: ԩ, reason: contains not printable characters */
            public void m6420() {
                if (this.f6918.compareAndSet(false, true)) {
                    this.f6914.m6419(this.f6915, this.f6916);
                }
            }
        }

        public DebounceSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
            this.downstream = subscriber;
            this.debounceSelector = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            InterfaceC4478 interfaceC4478 = this.debouncer.get();
            if (DisposableHelper.isDisposed(interfaceC4478)) {
                return;
            }
            C2021 c2021 = (C2021) interfaceC4478;
            if (c2021 != null) {
                c2021.m6420();
            }
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            InterfaceC4478 interfaceC4478 = this.debouncer.get();
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.debounceSelector.apply(t), "The publisher supplied is null");
                C2021 c2021 = new C2021(this, j, t);
                if (C4905.m14631(this.debouncer, interfaceC4478, c2021)) {
                    publisher.subscribe(c2021);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                this.downstream.onError(th);
            }
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
        public void m6419(long j, T t) {
            if (j == this.index) {
                if (get() != 0) {
                    this.downstream.onNext(t);
                    C5153.m15073(this, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }
    }

    public FlowableDebounce(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
        super(abstractC3630);
        this.f6913 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new DebounceSubscriber(new C4056(subscriber), this.f6913));
    }
}
