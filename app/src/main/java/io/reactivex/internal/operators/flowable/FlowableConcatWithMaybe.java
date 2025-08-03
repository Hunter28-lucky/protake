package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableConcatWithMaybe<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3517<? extends T> f6908;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements InterfaceC5216<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        public boolean inMaybe;
        public InterfaceC3517<? extends T> other;
        public final AtomicReference<InterfaceC4478> otherDisposable;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, InterfaceC3517<? extends T> interfaceC3517) {
            super(subscriber);
            this.other = interfaceC3517;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            InterfaceC3517<? extends T> interfaceC3517 = this.other;
            this.other = null;
            interfaceC3517.mo11463(this);
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

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.otherDisposable, interfaceC4478);
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            m7006(t);
        }
    }

    public FlowableConcatWithMaybe(AbstractC3630<T> abstractC3630, InterfaceC3517<? extends T> interfaceC3517) {
        super(abstractC3630);
        this.f6908 = interfaceC3517;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new ConcatWithSubscriber(subscriber, this.f6908));
    }
}
