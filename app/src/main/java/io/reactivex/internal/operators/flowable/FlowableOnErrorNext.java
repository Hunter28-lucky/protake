package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnErrorNext<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends Publisher<? extends T>> f7035;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7036;

    public static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements InterfaceC3899<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        public final boolean allowFatal;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public final InterfaceC2368<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
        public boolean once;
        public long produced;

        public OnErrorNextSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super Throwable, ? extends Publisher<? extends T>> interfaceC2368, boolean z) {
            super(false);
            this.downstream = subscriber;
            this.nextSupplier = interfaceC2368;
            this.allowFatal = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.once) {
                if (this.done) {
                    C3671.m11803(th);
                    return;
                } else {
                    this.downstream.onError(th);
                    return;
                }
            }
            this.once = true;
            if (this.allowFatal && !(th instanceof Exception)) {
                this.downstream.onError(th);
                return;
            }
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.nextSupplier.apply(th), "The nextSupplier returned a null Publisher");
                long j = this.produced;
                if (j != 0) {
                    m7014(j);
                }
                publisher.subscribe(this);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            m7015(subscription);
        }
    }

    public FlowableOnErrorNext(AbstractC3630<T> abstractC3630, InterfaceC2368<? super Throwable, ? extends Publisher<? extends T>> interfaceC2368, boolean z) {
        super(abstractC3630);
        this.f7035 = interfaceC2368;
        this.f7036 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f7035, this.f7036);
        subscriber.onSubscribe(onErrorNextSubscriber);
        this.f11385.subscribe((InterfaceC3899) onErrorNextSubscriber);
    }
}
