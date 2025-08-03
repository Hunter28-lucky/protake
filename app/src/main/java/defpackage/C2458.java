package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableTakeUntilPredicate.java */
/* renamed from: ƫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2458<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f9148;

    /* compiled from: FlowableTakeUntilPredicate.java */
    /* renamed from: ƫ$Ϳ, reason: contains not printable characters */
    public static final class C2459<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f9149;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f9150;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f9151;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f9152;

        public C2459(Subscriber<? super T> subscriber, InterfaceC4178<? super T> interfaceC4178) {
            this.f9149 = subscriber;
            this.f9150 = interfaceC4178;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f9151.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f9152) {
                return;
            }
            this.f9152 = true;
            this.f9149.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f9152) {
                C3671.m11803(th);
            } else {
                this.f9152 = true;
                this.f9149.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f9152) {
                return;
            }
            this.f9149.onNext(t);
            try {
                if (this.f9150.test(t)) {
                    this.f9152 = true;
                    this.f9151.cancel();
                    this.f9149.onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f9151.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f9151, subscription)) {
                this.f9151 = subscription;
                this.f9149.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f9151.request(j);
        }
    }

    public C2458(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        super(abstractC3630);
        this.f9148 = interfaceC4178;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2459(subscriber, this.f9148));
    }
}
