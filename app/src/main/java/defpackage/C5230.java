package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableScan.java */
/* renamed from: Ⴙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5230<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<T, T, T> f17340;

    /* compiled from: FlowableScan.java */
    /* renamed from: Ⴙ$Ϳ, reason: contains not printable characters */
    public static final class C5231<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f17341;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<T, T, T> f17342;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f17343;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f17344;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f17345;

        public C5231(Subscriber<? super T> subscriber, InterfaceC5247<T, T, T> interfaceC5247) {
            this.f17341 = subscriber;
            this.f17342 = interfaceC5247;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f17343.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17345) {
                return;
            }
            this.f17345 = true;
            this.f17341.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17345) {
                C3671.m11803(th);
            } else {
                this.f17345 = true;
                this.f17341.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17345) {
                return;
            }
            Subscriber<? super T> subscriber = this.f17341;
            T t2 = this.f17344;
            if (t2 == null) {
                this.f17344 = t;
                subscriber.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) C4246.m13353(this.f17342.apply(t2, t), "The value returned by the accumulator is null");
                this.f17344 = r4;
                subscriber.onNext(r4);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f17343.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17343, subscription)) {
                this.f17343 = subscription;
                this.f17341.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f17343.request(j);
        }
    }

    public C5230(AbstractC3630<T> abstractC3630, InterfaceC5247<T, T, T> interfaceC5247) {
        super(abstractC3630);
        this.f17340 = interfaceC5247;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5231(subscriber, this.f17340));
    }
}
