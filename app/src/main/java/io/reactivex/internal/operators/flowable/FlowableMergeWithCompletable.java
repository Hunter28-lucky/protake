package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4217;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2837 f7020;

    public static final class MergeWithSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Subscriber<? super T> downstream;
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        public final OtherObserver otherObserver = new OtherObserver(this);
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public static final class OtherObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithSubscriber<?> parent;

            public OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6525();
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6526(th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                C4217.m13297(this.downstream, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            C4217.m13299(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            C4217.m13301(this.downstream, t, this, this.error);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6525() {
            this.otherDone = true;
            if (this.mainDone) {
                C4217.m13297(this.downstream, this, this.error);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6526(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            C4217.m13299(this.downstream, th, this, this.error);
        }
    }

    public FlowableMergeWithCompletable(AbstractC3630<T> abstractC3630, InterfaceC2837 interfaceC2837) {
        super(abstractC3630);
        this.f7020 = interfaceC2837;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.f11385.subscribe((InterfaceC3899) mergeWithSubscriber);
        this.f7020.mo10180(mergeWithSubscriber.otherObserver);
    }
}
