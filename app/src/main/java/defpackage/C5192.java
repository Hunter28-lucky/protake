package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableDoOnLifecycle.java */
/* renamed from: Ⴀ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5192<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super Subscription> f17230;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC4719 f17231;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f17232;

    /* compiled from: FlowableDoOnLifecycle.java */
    /* renamed from: Ⴀ$Ϳ, reason: contains not printable characters */
    public static final class C5193<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f17233;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super Subscription> f17234;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC4719 f17235;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final InterfaceC3809 f17236;

        /* renamed from: ԯ, reason: contains not printable characters */
        public Subscription f17237;

        public C5193(Subscriber<? super T> subscriber, InterfaceC2857<? super Subscription> interfaceC2857, InterfaceC4719 interfaceC4719, InterfaceC3809 interfaceC3809) {
            this.f17233 = subscriber;
            this.f17234 = interfaceC2857;
            this.f17236 = interfaceC3809;
            this.f17235 = interfaceC4719;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.f17237;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f17237 = subscriptionHelper;
                try {
                    this.f17236.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
                subscription.cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17237 != SubscriptionHelper.CANCELLED) {
                this.f17233.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17237 != SubscriptionHelper.CANCELLED) {
                this.f17233.onError(th);
            } else {
                C3671.m11803(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f17233.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            try {
                this.f17234.accept(subscription);
                if (SubscriptionHelper.validate(this.f17237, subscription)) {
                    this.f17237 = subscription;
                    this.f17233.onSubscribe(this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                subscription.cancel();
                this.f17237 = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.f17233);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                this.f17235.accept(j);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
            this.f17237.request(j);
        }
    }

    public C5192(AbstractC3630<T> abstractC3630, InterfaceC2857<? super Subscription> interfaceC2857, InterfaceC4719 interfaceC4719, InterfaceC3809 interfaceC3809) {
        super(abstractC3630);
        this.f17230 = interfaceC2857;
        this.f17231 = interfaceC4719;
        this.f17232 = interfaceC3809;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5193(subscriber, this.f17230, this.f17231, this.f17232));
    }
}
