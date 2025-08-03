package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableZipIterable.java */
/* renamed from: ड, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4075<T, U, V> extends AbstractC3232<T, V> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<U> f14166;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<? super T, ? super U, ? extends V> f14167;

    /* compiled from: FlowableZipIterable.java */
    /* renamed from: ड$Ϳ, reason: contains not printable characters */
    public static final class C4076<T, U, V> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super V> f14168;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Iterator<U> f14169;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends V> f14170;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f14171;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f14172;

        public C4076(Subscriber<? super V> subscriber, Iterator<U> it, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
            this.f14168 = subscriber;
            this.f14169 = it;
            this.f14170 = interfaceC5247;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f14171.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f14172) {
                return;
            }
            this.f14172 = true;
            this.f14168.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f14172) {
                C3671.m11803(th);
            } else {
                this.f14172 = true;
                this.f14168.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f14172) {
                return;
            }
            try {
                try {
                    this.f14168.onNext(C4246.m13353(this.f14170.apply(t, C4246.m13353(this.f14169.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f14169.hasNext()) {
                            return;
                        }
                        this.f14172 = true;
                        this.f14171.cancel();
                        this.f14168.onComplete();
                    } catch (Throwable th) {
                        m13009(th);
                    }
                } catch (Throwable th2) {
                    m13009(th2);
                }
            } catch (Throwable th3) {
                m13009(th3);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14171, subscription)) {
                this.f14171 = subscription;
                this.f14168.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f14171.request(j);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m13009(Throwable th) {
            C4089.m13026(th);
            this.f14172 = true;
            this.f14171.cancel();
            this.f14168.onError(th);
        }
    }

    public C4075(AbstractC3630<T> abstractC3630, Iterable<U> iterable, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
        super(abstractC3630);
        this.f14166 = iterable;
        this.f14167 = interfaceC5247;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super V> subscriber) {
        try {
            Iterator it = (Iterator) C4246.m13353(this.f14166.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f11385.subscribe((InterfaceC3899) new C4076(subscriber, it, this.f14167));
                } else {
                    EmptySubscription.complete(subscriber);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
