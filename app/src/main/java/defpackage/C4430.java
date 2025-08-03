package defpackage;

import io.reactivex.internal.operators.flowable.FlowableAny;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableAnySingle.java */
/* renamed from: ମ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4430<T> extends AbstractC4838<Boolean> implements InterfaceC2583<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f15273;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f15274;

    /* compiled from: FlowableAnySingle.java */
    /* renamed from: ମ$Ϳ, reason: contains not printable characters */
    public static final class C4431<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f15275;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f15276;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f15277;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15278;

        public C4431(InterfaceC4782<? super Boolean> interfaceC4782, InterfaceC4178<? super T> interfaceC4178) {
            this.f15275 = interfaceC4782;
            this.f15276 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15277.cancel();
            this.f15277 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15277 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f15278) {
                return;
            }
            this.f15278 = true;
            this.f15277 = SubscriptionHelper.CANCELLED;
            this.f15275.onSuccess(Boolean.FALSE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f15278) {
                C3671.m11803(th);
                return;
            }
            this.f15278 = true;
            this.f15277 = SubscriptionHelper.CANCELLED;
            this.f15275.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f15278) {
                return;
            }
            try {
                if (this.f15276.test(t)) {
                    this.f15278 = true;
                    this.f15277.cancel();
                    this.f15277 = SubscriptionHelper.CANCELLED;
                    this.f15275.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15277.cancel();
                this.f15277 = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15277, subscription)) {
                this.f15277 = subscription;
                this.f15275.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4430(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        this.f15273 = abstractC3630;
        this.f15274 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        this.f15273.subscribe((InterfaceC3899) new C4431(interfaceC4782, this.f15274));
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<Boolean> mo6444() {
        return C3671.m11796(new FlowableAny(this.f15273, this.f15274));
    }
}
