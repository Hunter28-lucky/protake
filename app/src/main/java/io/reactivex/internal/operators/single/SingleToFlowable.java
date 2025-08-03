package io.reactivex.internal.operators.single;

import defpackage.AbstractC3630;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class SingleToFlowable<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7624;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements InterfaceC4782<T> {
        private static final long serialVersionUID = 187782011903685568L;
        public InterfaceC4478 upstream;

        public SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            m7008(t);
        }
    }

    public SingleToFlowable(InterfaceC3951<? extends T> interfaceC3951) {
        this.f7624 = interfaceC3951;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f7624.subscribe(new SingleToFlowableObserver(subscriber));
    }
}
