package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableTakeWhile.java */
/* renamed from: ͽ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2767<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f10121;

    /* compiled from: FlowableTakeWhile.java */
    /* renamed from: ͽ$Ϳ, reason: contains not printable characters */
    public static final class C2768<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f10122;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f10123;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f10124;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10125;

        public C2768(Subscriber<? super T> subscriber, InterfaceC4178<? super T> interfaceC4178) {
            this.f10122 = subscriber;
            this.f10123 = interfaceC4178;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f10124.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f10125) {
                return;
            }
            this.f10125 = true;
            this.f10122.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f10125) {
                C3671.m11803(th);
            } else {
                this.f10125 = true;
                this.f10122.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f10125) {
                return;
            }
            try {
                if (this.f10123.test(t)) {
                    this.f10122.onNext(t);
                    return;
                }
                this.f10125 = true;
                this.f10124.cancel();
                this.f10122.onComplete();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f10124.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10124, subscription)) {
                this.f10124 = subscription;
                this.f10122.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f10124.request(j);
        }
    }

    public C2767(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        super(abstractC3630);
        this.f10121 = interfaceC4178;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2768(subscriber, this.f10121));
    }
}
