package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableSkip.java */
/* renamed from: ɢ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2586<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f9629;

    /* compiled from: FlowableSkip.java */
    /* renamed from: ɢ$Ϳ, reason: contains not printable characters */
    public static final class C2587<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f9630;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public long f9631;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f9632;

        public C2587(Subscriber<? super T> subscriber, long j) {
            this.f9630 = subscriber;
            this.f9631 = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f9632.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f9630.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f9630.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.f9631;
            if (j != 0) {
                this.f9631 = j - 1;
            } else {
                this.f9630.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f9632, subscription)) {
                long j = this.f9631;
                this.f9632 = subscription;
                this.f9630.onSubscribe(this);
                subscription.request(j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f9632.request(j);
        }
    }

    public C2586(AbstractC3630<T> abstractC3630, long j) {
        super(abstractC3630);
        this.f9629 = j;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2587(subscriber, this.f9629));
    }
}
