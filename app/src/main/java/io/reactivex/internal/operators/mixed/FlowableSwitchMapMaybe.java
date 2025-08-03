package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapMaybe<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7251;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> f7252;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7253;

    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapMaybeObserver<Object> f7254 = new SwitchMapMaybeObserver<>(null);
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> mapper;
        public Subscription upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC5216<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapMaybeSubscriber<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.parent = switchMapMaybeSubscriber;
            }

            @Override // defpackage.InterfaceC5216
            public void onComplete() {
                this.parent.m6696(this);
            }

            @Override // defpackage.InterfaceC5216
            public void onError(Throwable th) {
                this.parent.m6697(this, th);
            }

            @Override // defpackage.InterfaceC5216
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC5216
            public void onSuccess(R r) {
                this.item = r;
                this.parent.m6695();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6698() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            m6694();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6695();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6694();
            }
            this.done = true;
            m6695();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.m6698();
            }
            try {
                InterfaceC3517 interfaceC3517 = (InterfaceC3517) C4246.m13353(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == f7254) {
                        return;
                    }
                } while (!C4905.m14631(this.inner, switchMapMaybeObserver, switchMapMaybeObserver3));
                interfaceC3517.mo11463(switchMapMaybeObserver3);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.cancel();
                this.inner.getAndSet(f7254);
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
            m6695();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6694() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f7254;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            switchMapMaybeObserver2.m6698();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6695() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    subscriber.onError(atomicThrowable.m7019());
                    return;
                }
                boolean z = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
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
                if (z2 || switchMapMaybeObserver.item == null || j == atomicLong.get()) {
                    this.emitted = j;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    C4905.m14631(atomicReference, switchMapMaybeObserver, null);
                    subscriber.onNext(switchMapMaybeObserver.item);
                    j++;
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6696(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (C4905.m14631(this.inner, switchMapMaybeObserver, null)) {
                m6695();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6697(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!C4905.m14631(this.inner, switchMapMaybeObserver, null) || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                m6694();
            }
            m6695();
        }
    }

    public FlowableSwitchMapMaybe(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
        this.f7251 = abstractC3630;
        this.f7252 = interfaceC2368;
        this.f7253 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7251.subscribe((InterfaceC3899) new SwitchMapMaybeSubscriber(subscriber, this.f7252, this.f7253));
    }
}
