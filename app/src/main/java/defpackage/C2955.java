package defpackage;

import io.reactivex.internal.operators.flowable.FlowableCount;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableCountSingle.java */
/* renamed from: Ҏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2955<T> extends AbstractC4838<Long> implements InterfaceC2583<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f10676;

    /* compiled from: FlowableCountSingle.java */
    /* renamed from: Ҏ$Ϳ, reason: contains not printable characters */
    public static final class C2956 implements InterfaceC3899<Object>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Long> f10677;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f10678;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f10679;

        public C2956(InterfaceC4782<? super Long> interfaceC4782) {
            this.f10677 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10678.cancel();
            this.f10678 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10678 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f10678 = SubscriptionHelper.CANCELLED;
            this.f10677.onSuccess(Long.valueOf(this.f10679));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f10678 = SubscriptionHelper.CANCELLED;
            this.f10677.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.f10679++;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10678, subscription)) {
                this.f10678 = subscription;
                this.f10677.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C2955(AbstractC3630<T> abstractC3630) {
        this.f10676 = abstractC3630;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Long> interfaceC4782) {
        this.f10676.subscribe((InterfaceC3899) new C2956(interfaceC4782));
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<Long> mo6444() {
        return C3671.m11796(new FlowableCount(this.f10676));
    }
}
