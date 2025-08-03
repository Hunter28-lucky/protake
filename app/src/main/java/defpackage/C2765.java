package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableHide.java */
/* renamed from: ͼ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2765<T> extends AbstractC3232<T, T> {

    /* compiled from: FlowableHide.java */
    /* renamed from: ͼ$Ϳ, reason: contains not printable characters */
    public static final class C2766<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f10119;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f10120;

        public C2766(Subscriber<? super T> subscriber) {
            this.f10119 = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f10120.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f10119.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f10119.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f10119.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10120, subscription)) {
                this.f10120 = subscription;
                this.f10119.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f10120.request(j);
        }
    }

    public C2765(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2766(subscriber));
    }
}
