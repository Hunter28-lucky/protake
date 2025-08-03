package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableUsing<T, D> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends D> f7176;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super D, ? extends Publisher<? extends T>> f7177;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super D> f7178;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7179;

    public static final class UsingSubscriber<T, D> extends AtomicBoolean implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;
        public final InterfaceC2857<? super D> disposer;
        public final Subscriber<? super T> downstream;
        public final boolean eager;
        public final D resource;
        public Subscription upstream;

        public UsingSubscriber(Subscriber<? super T> subscriber, D d, InterfaceC2857<? super D> interfaceC2857, boolean z) {
            this.downstream = subscriber;
            this.resource = d;
            this.disposer = interfaceC2857;
            this.eager = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            m6651();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.cancel();
                m6651();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.eager) {
                this.downstream.onError(th);
                this.upstream.cancel();
                m6651();
                return;
            }
            Throwable th2 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    th2 = th3;
                    C4089.m13026(th2);
                }
            }
            this.upstream.cancel();
            if (th2 != null) {
                this.downstream.onError(new CompositeException(th, th2));
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6651() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public FlowableUsing(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends Publisher<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857, boolean z) {
        this.f7176 = callable;
        this.f7177 = interfaceC2368;
        this.f7178 = interfaceC2857;
        this.f7179 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            D dCall = this.f7176.call();
            try {
                ((Publisher) C4246.m13353(this.f7177.apply(dCall), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(subscriber, dCall, this.f7178, this.f7179));
            } catch (Throwable th) {
                C4089.m13026(th);
                try {
                    this.f7178.accept(dCall);
                    EmptySubscription.error(th, subscriber);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    EmptySubscription.error(new CompositeException(th, th2), subscriber);
                }
            }
        } catch (Throwable th3) {
            C4089.m13026(th3);
            EmptySubscription.error(th3, subscriber);
        }
    }
}
