package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SingleTakeUntil<T, U> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7614;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<U> f7615;

    public static final class TakeUntilMainObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -622603812305745221L;
        public final InterfaceC4782<? super T> downstream;
        public final TakeUntilOtherSubscriber other = new TakeUntilOtherSubscriber(this);

        public TakeUntilMainObserver(InterfaceC4782<? super T> interfaceC4782) {
            this.downstream = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
            this.other.m6961();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.other.m6961();
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || getAndSet(disposableHelper) == disposableHelper) {
                C3671.m11803(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.other.m6961();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onSuccess(t);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6960(Throwable th) {
            InterfaceC4478 andSet;
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                C3671.m11803(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.downstream.onError(th);
        }
    }

    public static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        public final TakeUntilMainObserver<?> parent;

        public TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.parent = takeUntilMainObserver;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.m6960(new CancellationException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.m6960(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.m6960(new CancellationException());
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6961() {
            SubscriptionHelper.cancel(this);
        }
    }

    public SingleTakeUntil(InterfaceC3951<T> interfaceC3951, Publisher<U> publisher) {
        this.f7614 = interfaceC3951;
        this.f7615 = publisher;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(interfaceC4782);
        interfaceC4782.onSubscribe(takeUntilMainObserver);
        this.f7615.subscribe(takeUntilMainObserver.other);
        this.f7614.subscribe(takeUntilMainObserver);
    }
}
