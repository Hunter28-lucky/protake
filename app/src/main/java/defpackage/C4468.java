package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableSwitchIfEmpty.java */
/* renamed from: ச, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4468<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends T> f15367;

    /* compiled from: FlowableSwitchIfEmpty.java */
    /* renamed from: ச$Ϳ, reason: contains not printable characters */
    public static final class C4469<T> implements InterfaceC3899<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f15368;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Publisher<? extends T> f15369;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15371 = true;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final SubscriptionArbiter f15370 = new SubscriptionArbiter(false);

        public C4469(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.f15368 = subscriber;
            this.f15369 = publisher;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f15371) {
                this.f15368.onComplete();
            } else {
                this.f15371 = false;
                this.f15369.subscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f15368.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f15371) {
                this.f15371 = false;
            }
            this.f15368.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.f15370.m7015(subscription);
        }
    }

    public C4468(AbstractC3630<T> abstractC3630, Publisher<? extends T> publisher) {
        super(abstractC3630);
        this.f15367 = publisher;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        C4469 c4469 = new C4469(subscriber, this.f15367);
        subscriber.onSubscribe(c4469.f15370);
        this.f11385.subscribe((InterfaceC3899) c4469);
    }
}
