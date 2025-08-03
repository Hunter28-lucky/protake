package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableIgnoreElements.java */
/* renamed from: პ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5281<T> extends AbstractC3232<T, T> {

    /* compiled from: FlowableIgnoreElements.java */
    /* renamed from: პ$Ϳ, reason: contains not printable characters */
    public static final class C5282<T> implements InterfaceC3899<T>, InterfaceC2968<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f17463;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f17464;

        public C5282(Subscriber<? super T> subscriber) {
            this.f17463 = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f17464.cancel();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return true;
        }

        @Override // defpackage.InterfaceC4851
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f17463.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f17463.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17464, subscription)) {
                this.f17464 = subscription;
                this.f17463.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return i & 2;
        }
    }

    public C5281(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5282(subscriber));
    }
}
