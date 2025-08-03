package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4495;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SingleDelayWithPublisher<T, U> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7578;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<U> f7579;

    public static final class OtherSubscriber<T, U> extends AtomicReference<InterfaceC4478> implements InterfaceC3899<U>, InterfaceC4478 {
        private static final long serialVersionUID = -8565274649390031272L;
        public boolean done;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3951<T> source;
        public Subscription upstream;

        public OtherSubscriber(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<T> interfaceC3951) {
            this.downstream = interfaceC4782;
            this.source = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.subscribe(new C4495(this, this.downstream));
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
        public void onNext(U u) {
            this.upstream.cancel();
            onComplete();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleDelayWithPublisher(InterfaceC3951<T> interfaceC3951, Publisher<U> publisher) {
        this.f7578 = interfaceC3951;
        this.f7579 = publisher;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7579.subscribe(new OtherSubscriber(interfaceC4782, this.f7578));
    }
}
