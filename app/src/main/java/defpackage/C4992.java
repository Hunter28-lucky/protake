package defpackage;

import io.reactivex.internal.operators.flowable.FlowableSingle;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableSingleMaybe.java */
/* renamed from: ອ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4992<T> extends AbstractC4274<T> implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f16746;

    /* compiled from: FlowableSingleMaybe.java */
    /* renamed from: ອ$Ϳ, reason: contains not printable characters */
    public static final class C4993<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f16747;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f16748;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f16749;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f16750;

        public C4993(InterfaceC5216<? super T> interfaceC5216) {
            this.f16747 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16748.cancel();
            this.f16748 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16748 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f16749) {
                return;
            }
            this.f16749 = true;
            this.f16748 = SubscriptionHelper.CANCELLED;
            T t = this.f16750;
            this.f16750 = null;
            if (t == null) {
                this.f16747.onComplete();
            } else {
                this.f16747.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f16749) {
                C3671.m11803(th);
                return;
            }
            this.f16749 = true;
            this.f16748 = SubscriptionHelper.CANCELLED;
            this.f16747.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f16749) {
                return;
            }
            if (this.f16750 == null) {
                this.f16750 = t;
                return;
            }
            this.f16749 = true;
            this.f16748.cancel();
            this.f16748 = SubscriptionHelper.CANCELLED;
            this.f16747.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16748, subscription)) {
                this.f16748 = subscription;
                this.f16747.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4992(AbstractC3630<T> abstractC3630) {
        this.f16746 = abstractC3630;
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableSingle(this.f16746, null, false));
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f16746.subscribe((InterfaceC3899) new C4993(interfaceC5216));
    }
}
