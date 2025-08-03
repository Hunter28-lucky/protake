package io.reactivex.internal.operators.single;

import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SingleFlatMapPublisher<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7600;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f7601;

    public SingleFlatMapPublisher(InterfaceC3951<T> interfaceC3951, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        this.f7600 = interfaceC3951;
        this.f7601 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7600.subscribe(new SingleFlatMapPublisherObserver(subscriber, this.f7601));
    }

    public static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements InterfaceC4782<S>, InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;
        public InterfaceC4478 disposable;
        public final Subscriber<? super T> downstream;
        public final InterfaceC2368<? super S, ? extends Publisher<? extends T>> mapper;
        public final AtomicReference<Subscription> parent = new AtomicReference<>();

        public SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, InterfaceC2368<? super S, ? extends Publisher<? extends T>> interfaceC2368) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.disposable = interfaceC4478;
            this.downstream.onSubscribe(this);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(S s) {
            try {
                ((Publisher) C4246.m13353(this.mapper.apply(s), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.parent, this, j);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, subscription);
        }
    }
}
