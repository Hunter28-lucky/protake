package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* compiled from: FlowableReduceSeedSingle.java */
/* renamed from: Ӳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3127<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f11126;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final R f11127;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f11128;

    /* compiled from: FlowableReduceSeedSingle.java */
    /* renamed from: Ӳ$Ϳ, reason: contains not printable characters */
    public static final class C3128<T, R> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super R> f11129;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<R, ? super T, R> f11130;

        /* renamed from: ԭ, reason: contains not printable characters */
        public R f11131;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f11132;

        public C3128(InterfaceC4782<? super R> interfaceC4782, InterfaceC5247<R, ? super T, R> interfaceC5247, R r) {
            this.f11129 = interfaceC4782;
            this.f11131 = r;
            this.f11130 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11132.cancel();
            this.f11132 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11132 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            R r = this.f11131;
            if (r != null) {
                this.f11131 = null;
                this.f11132 = SubscriptionHelper.CANCELLED;
                this.f11129.onSuccess(r);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f11131 == null) {
                C3671.m11803(th);
                return;
            }
            this.f11131 = null;
            this.f11132 = SubscriptionHelper.CANCELLED;
            this.f11129.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            R r = this.f11131;
            if (r != null) {
                try {
                    this.f11131 = (R) C4246.m13353(this.f11130.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f11132.cancel();
                    onError(th);
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11132, subscription)) {
                this.f11132 = subscription;
                this.f11129.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3127(Publisher<T> publisher, R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        this.f11126 = publisher;
        this.f11127 = r;
        this.f11128 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        this.f11126.subscribe(new C3128(interfaceC4782, this.f11128, this.f11127));
    }
}
