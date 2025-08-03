package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatWithCompletable<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2837 f6907;

    public FlowableConcatWithCompletable(AbstractC3630<T> abstractC3630, InterfaceC2837 interfaceC2837) {
        super(abstractC3630);
        this.f6907 = interfaceC2837;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new ConcatWithSubscriber(subscriber, this.f6907));
    }

    public static final class ConcatWithSubscriber<T> extends AtomicReference<InterfaceC4478> implements InterfaceC3899<T>, InterfaceC5053, Subscription {
        private static final long serialVersionUID = -7346385463600070225L;
        public final Subscriber<? super T> downstream;
        public boolean inCompletable;
        public InterfaceC2837 other;
        public Subscription upstream;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, InterfaceC2837 interfaceC2837) {
            this.downstream = subscriber;
            this.other = interfaceC2837;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            InterfaceC2837 interfaceC2837 = this.other;
            this.other = null;
            interfaceC2837.mo10180(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
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

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }
}
