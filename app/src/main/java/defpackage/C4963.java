package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* compiled from: FlowableLastSingle.java */
/* renamed from: ນ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4963<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f16688;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f16689;

    /* compiled from: FlowableLastSingle.java */
    /* renamed from: ນ$Ϳ, reason: contains not printable characters */
    public static final class C4964<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16690;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f16691;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f16692;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f16693;

        public C4964(InterfaceC4782<? super T> interfaceC4782, T t) {
            this.f16690 = interfaceC4782;
            this.f16691 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16692.cancel();
            this.f16692 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16692 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f16692 = SubscriptionHelper.CANCELLED;
            T t = this.f16693;
            if (t != null) {
                this.f16693 = null;
                this.f16690.onSuccess(t);
                return;
            }
            T t2 = this.f16691;
            if (t2 != null) {
                this.f16690.onSuccess(t2);
            } else {
                this.f16690.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f16692 = SubscriptionHelper.CANCELLED;
            this.f16693 = null;
            this.f16690.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f16693 = t;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16692, subscription)) {
                this.f16692 = subscription;
                this.f16690.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4963(Publisher<T> publisher, T t) {
        this.f16688 = publisher;
        this.f16689 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16688.subscribe(new C4964(interfaceC4782, this.f16689));
    }
}
