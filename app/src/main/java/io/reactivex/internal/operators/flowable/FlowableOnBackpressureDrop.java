package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractC3232<T, T> implements InterfaceC2857<T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f7034;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public final InterfaceC2857<? super T> onDrop;
        public Subscription upstream;

        public BackpressureDropSubscriber(Subscriber<? super T> subscriber, InterfaceC2857<? super T> interfaceC2857) {
            this.downstream = subscriber;
            this.onDrop = interfaceC2857;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t);
                C5153.m15073(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
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
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this, j);
            }
        }
    }

    public FlowableOnBackpressureDrop(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
        this.f7034 = this;
    }

    @Override // defpackage.InterfaceC2857
    public void accept(T t) {
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new BackpressureDropSubscriber(subscriber, this.f7034));
    }

    public FlowableOnBackpressureDrop(AbstractC3630<T> abstractC3630, InterfaceC2857<? super T> interfaceC2857) {
        super(abstractC3630);
        this.f7034 = interfaceC2857;
    }
}
