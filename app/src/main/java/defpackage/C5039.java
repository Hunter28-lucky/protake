package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableSkipWhile.java */
/* renamed from: དྷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5039<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f16812;

    /* compiled from: FlowableSkipWhile.java */
    /* renamed from: དྷ$Ϳ, reason: contains not printable characters */
    public static final class C5040<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f16813;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f16814;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f16815;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f16816;

        public C5040(Subscriber<? super T> subscriber, InterfaceC4178<? super T> interfaceC4178) {
            this.f16813 = subscriber;
            this.f16814 = interfaceC4178;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f16815.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f16813.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f16813.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f16816) {
                this.f16813.onNext(t);
                return;
            }
            try {
                if (this.f16814.test(t)) {
                    this.f16815.request(1L);
                } else {
                    this.f16816 = true;
                    this.f16813.onNext(t);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16815.cancel();
                this.f16813.onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16815, subscription)) {
                this.f16815 = subscription;
                this.f16813.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f16815.request(j);
        }
    }

    public C5039(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        super(abstractC3630);
        this.f16812 = interfaceC4178;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5040(subscriber, this.f16812));
    }
}
