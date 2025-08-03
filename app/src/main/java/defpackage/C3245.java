package defpackage;

import io.reactivex.internal.operators.flowable.FlowableAll;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableAllSingle.java */
/* renamed from: ճ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3245<T> extends AbstractC4838<Boolean> implements InterfaceC2583<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f11408;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f11409;

    /* compiled from: FlowableAllSingle.java */
    /* renamed from: ճ$Ϳ, reason: contains not printable characters */
    public static final class C3246<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f11410;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f11411;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f11412;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f11413;

        public C3246(InterfaceC4782<? super Boolean> interfaceC4782, InterfaceC4178<? super T> interfaceC4178) {
            this.f11410 = interfaceC4782;
            this.f11411 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11412.cancel();
            this.f11412 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11412 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f11413) {
                return;
            }
            this.f11413 = true;
            this.f11412 = SubscriptionHelper.CANCELLED;
            this.f11410.onSuccess(Boolean.TRUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f11413) {
                C3671.m11803(th);
                return;
            }
            this.f11413 = true;
            this.f11412 = SubscriptionHelper.CANCELLED;
            this.f11410.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f11413) {
                return;
            }
            try {
                if (this.f11411.test(t)) {
                    return;
                }
                this.f11413 = true;
                this.f11412.cancel();
                this.f11412 = SubscriptionHelper.CANCELLED;
                this.f11410.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f11412.cancel();
                this.f11412 = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11412, subscription)) {
                this.f11412 = subscription;
                this.f11410.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3245(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        this.f11408 = abstractC3630;
        this.f11409 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        this.f11408.subscribe((InterfaceC3899) new C3246(interfaceC4782, this.f11409));
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<Boolean> mo6444() {
        return C3671.m11796(new FlowableAll(this.f11408, this.f11409));
    }
}
