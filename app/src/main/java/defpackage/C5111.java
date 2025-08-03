package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableIgnoreElementsCompletable.java */
/* renamed from: ဖ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5111<T> extends AbstractC2900 implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f16951;

    /* compiled from: FlowableIgnoreElementsCompletable.java */
    /* renamed from: ဖ$Ϳ, reason: contains not printable characters */
    public static final class C5112<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f16952;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f16953;

        public C5112(InterfaceC5053 interfaceC5053) {
            this.f16952 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16953.cancel();
            this.f16953 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16953 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f16953 = SubscriptionHelper.CANCELLED;
            this.f16952.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f16953 = SubscriptionHelper.CANCELLED;
            this.f16952.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16953, subscription)) {
                this.f16953 = subscription;
                this.f16952.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C5111(AbstractC3630<T> abstractC3630) {
        this.f16951 = abstractC3630;
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new C5281(this.f16951));
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f16951.subscribe((InterfaceC3899) new C5112(interfaceC5053));
    }
}
