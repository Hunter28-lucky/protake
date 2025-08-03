package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableConcatWithSingle<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f6909;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements InterfaceC4782<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        public InterfaceC3951<? extends T> other;
        public final AtomicReference<InterfaceC4478> otherDisposable;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, InterfaceC3951<? extends T> interfaceC3951) {
            super(subscriber);
            this.other = interfaceC3951;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            InterfaceC3951<? extends T> interfaceC3951 = this.other;
            this.other = null;
            interfaceC3951.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.otherDisposable, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            m7006(t);
        }
    }

    public FlowableConcatWithSingle(AbstractC3630<T> abstractC3630, InterfaceC3951<? extends T> interfaceC3951) {
        super(abstractC3630);
        this.f6909 = interfaceC3951;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new ConcatWithSubscriber(subscriber, this.f6909));
    }
}
