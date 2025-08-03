package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableDetach.java */
/* renamed from: ٹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3500<T> extends AbstractC3232<T, T> {

    /* compiled from: FlowableDetach.java */
    /* renamed from: ٹ$Ϳ, reason: contains not printable characters */
    public static final class C3501<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public Subscriber<? super T> f12265;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f12266;

        public C3501(Subscriber<? super T> subscriber) {
            this.f12265 = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.f12266;
            this.f12266 = EmptyComponent.INSTANCE;
            this.f12265 = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscriber<? super T> subscriber = this.f12265;
            this.f12266 = EmptyComponent.INSTANCE;
            this.f12265 = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.f12265;
            this.f12266 = EmptyComponent.INSTANCE;
            this.f12265 = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f12265.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f12266, subscription)) {
                this.f12266 = subscription;
                this.f12265.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f12266.request(j);
        }
    }

    public C3500(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C3501(subscriber));
    }
}
