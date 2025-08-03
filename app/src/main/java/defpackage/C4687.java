package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: SafeSubscriber.java */
/* renamed from: ഓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4687<T> implements InterfaceC3899<T>, Subscription {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Subscriber<? super T> f15907;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Subscription f15908;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f15909;

    public C4687(Subscriber<? super T> subscriber) {
        this.f15907 = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        try {
            this.f15908.cancel();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f15909) {
            return;
        }
        this.f15909 = true;
        if (this.f15908 == null) {
            m14199();
            return;
        }
        try {
            this.f15907.onComplete();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f15909) {
            C3671.m11803(th);
            return;
        }
        this.f15909 = true;
        if (this.f15908 != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f15907.onError(th);
                return;
            } catch (Throwable th2) {
                C4089.m13026(th2);
                C3671.m11803(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f15907.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f15907.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                C4089.m13026(th3);
                C3671.m11803(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            C4089.m13026(th4);
            C3671.m11803(new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f15909) {
            return;
        }
        if (this.f15908 == null) {
            m14200();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f15908.cancel();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                C4089.m13026(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.f15907.onNext(t);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            try {
                this.f15908.cancel();
                onError(th2);
            } catch (Throwable th3) {
                C4089.m13026(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f15908, subscription)) {
            this.f15908 = subscription;
            try {
                this.f15907.onSubscribe(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15909 = true;
                try {
                    subscription.cancel();
                    C3671.m11803(th);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    C3671.m11803(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        try {
            this.f15908.request(j);
        } catch (Throwable th) {
            C4089.m13026(th);
            try {
                this.f15908.cancel();
                C3671.m11803(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                C3671.m11803(new CompositeException(th, th2));
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14199() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f15907.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f15907.onError(nullPointerException);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(nullPointerException, th2));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14200() {
        this.f15909 = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f15907.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f15907.onError(nullPointerException);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(nullPointerException, th2));
        }
    }
}
