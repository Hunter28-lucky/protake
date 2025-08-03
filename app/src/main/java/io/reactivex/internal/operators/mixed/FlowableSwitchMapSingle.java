package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapSingle<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7255;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7256;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7257;

    public static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapSingleObserver<Object> f7258 = new SwitchMapSingleObserver<>(null);
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;
        public Subscription upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapSingleSubscriber<?, R> parent;

            public SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.parent = switchMapSingleSubscriber;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.parent.m6701(this, th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                this.item = r;
                this.parent.m6700();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6702() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            m6699();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6700();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6699();
            }
            this.done = true;
            m6700();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.m6702();
            }
            try {
                InterfaceC3951 interfaceC3951 = (InterfaceC3951) C4246.m13353(this.mapper.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == f7258) {
                        return;
                    }
                } while (!C4905.m14631(this.inner, switchMapSingleObserver, switchMapSingleObserver3));
                interfaceC3951.subscribe(switchMapSingleObserver3);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.cancel();
                this.inner.getAndSet(f7258);
                onError(th);
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
            C5153.m15069(this.requested, j);
            m6700();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6699() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f7258;
            SwitchMapSingleObserver<Object> switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            switchMapSingleObserver2.m6702();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6700() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    subscriber.onError(atomicThrowable.m7019());
                    return;
                }
                boolean z = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
                if (z && z2) {
                    Throwable thM7019 = atomicThrowable.m7019();
                    if (thM7019 != null) {
                        subscriber.onError(thM7019);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapSingleObserver.item == null || j == atomicLong.get()) {
                    this.emitted = j;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    C4905.m14631(atomicReference, switchMapSingleObserver, null);
                    subscriber.onNext(switchMapSingleObserver.item);
                    j++;
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6701(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!C4905.m14631(this.inner, switchMapSingleObserver, null) || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                m6699();
            }
            m6700();
        }
    }

    public FlowableSwitchMapSingle(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        this.f7255 = abstractC3630;
        this.f7256 = interfaceC2368;
        this.f7257 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7255.subscribe((InterfaceC3899) new SwitchMapSingleSubscriber(subscriber, this.f7256, this.f7257));
    }
}
