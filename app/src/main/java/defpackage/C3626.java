package defpackage;

import io.reactivex.internal.operators.flowable.FlowableSingle;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* compiled from: FlowableSingleSingle.java */
/* renamed from: ۇ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3626<T> extends AbstractC4838<T> implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f12580;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f12581;

    /* compiled from: FlowableSingleSingle.java */
    /* renamed from: ۇ$Ϳ, reason: contains not printable characters */
    public static final class C3627<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f12582;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f12583;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f12584;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f12585;

        /* renamed from: ԯ, reason: contains not printable characters */
        public T f12586;

        public C3627(InterfaceC4782<? super T> interfaceC4782, T t) {
            this.f12582 = interfaceC4782;
            this.f12583 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12584.cancel();
            this.f12584 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12584 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f12585) {
                return;
            }
            this.f12585 = true;
            this.f12584 = SubscriptionHelper.CANCELLED;
            T t = this.f12586;
            this.f12586 = null;
            if (t == null) {
                t = this.f12583;
            }
            if (t != null) {
                this.f12582.onSuccess(t);
            } else {
                this.f12582.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f12585) {
                C3671.m11803(th);
                return;
            }
            this.f12585 = true;
            this.f12584 = SubscriptionHelper.CANCELLED;
            this.f12582.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f12585) {
                return;
            }
            if (this.f12586 == null) {
                this.f12586 = t;
                return;
            }
            this.f12585 = true;
            this.f12584.cancel();
            this.f12584 = SubscriptionHelper.CANCELLED;
            this.f12582.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f12584, subscription)) {
                this.f12584 = subscription;
                this.f12582.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3626(AbstractC3630<T> abstractC3630, T t) {
        this.f12580 = abstractC3630;
        this.f12581 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f12580.subscribe((InterfaceC3899) new C3627(interfaceC4782, this.f12581));
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableSingle(this.f12580, this.f12581, true));
    }
}
