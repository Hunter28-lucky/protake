package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* compiled from: ObservableFromPublisher.java */
/* renamed from: გ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5257<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f17410;

    /* compiled from: ObservableFromPublisher.java */
    /* renamed from: გ$Ϳ, reason: contains not printable characters */
    public static final class C5258<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f17411;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f17412;

        public C5258(InterfaceC5102<? super T> interfaceC5102) {
            this.f17411 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f17412.cancel();
            this.f17412 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f17412 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f17411.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f17411.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f17411.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17412, subscription)) {
                this.f17412 = subscription;
                this.f17411.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C5257(Publisher<? extends T> publisher) {
        this.f17410 = publisher;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f17410.subscribe(new C5258(interfaceC5102));
    }
}
