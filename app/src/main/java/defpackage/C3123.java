package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* compiled from: FlowableLastMaybe.java */
/* renamed from: Ӯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3123<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f11113;

    /* compiled from: FlowableLastMaybe.java */
    /* renamed from: Ӯ$Ϳ, reason: contains not printable characters */
    public static final class C3124<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f11114;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f11115;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f11116;

        public C3124(InterfaceC5216<? super T> interfaceC5216) {
            this.f11114 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11115.cancel();
            this.f11115 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11115 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f11115 = SubscriptionHelper.CANCELLED;
            T t = this.f11116;
            if (t == null) {
                this.f11114.onComplete();
            } else {
                this.f11116 = null;
                this.f11114.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f11115 = SubscriptionHelper.CANCELLED;
            this.f11116 = null;
            this.f11114.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f11116 = t;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11115, subscription)) {
                this.f11115 = subscription;
                this.f11114.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3123(Publisher<T> publisher) {
        this.f11113 = publisher;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f11113.subscribe(new C3124(interfaceC5216));
    }
}
