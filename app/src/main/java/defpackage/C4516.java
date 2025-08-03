package defpackage;

import io.reactivex.internal.operators.flowable.FlowableElementAt;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableElementAtMaybe.java */
/* renamed from: గ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4516<T> extends AbstractC4274<T> implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f15460;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f15461;

    /* compiled from: FlowableElementAtMaybe.java */
    /* renamed from: గ$Ϳ, reason: contains not printable characters */
    public static final class C4517<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f15462;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f15463;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f15464;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f15465;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f15466;

        public C4517(InterfaceC5216<? super T> interfaceC5216, long j) {
            this.f15462 = interfaceC5216;
            this.f15463 = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15464.cancel();
            this.f15464 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15464 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f15464 = SubscriptionHelper.CANCELLED;
            if (this.f15466) {
                return;
            }
            this.f15466 = true;
            this.f15462.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f15466) {
                C3671.m11803(th);
                return;
            }
            this.f15466 = true;
            this.f15464 = SubscriptionHelper.CANCELLED;
            this.f15462.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f15466) {
                return;
            }
            long j = this.f15465;
            if (j != this.f15463) {
                this.f15465 = j + 1;
                return;
            }
            this.f15466 = true;
            this.f15464.cancel();
            this.f15464 = SubscriptionHelper.CANCELLED;
            this.f15462.onSuccess(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15464, subscription)) {
                this.f15464 = subscription;
                this.f15462.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4516(AbstractC3630<T> abstractC3630, long j) {
        this.f15460 = abstractC3630;
        this.f15461 = j;
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableElementAt(this.f15460, this.f15461, null, false));
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f15460.subscribe((InterfaceC3899) new C4517(interfaceC5216, this.f15461));
    }
}
