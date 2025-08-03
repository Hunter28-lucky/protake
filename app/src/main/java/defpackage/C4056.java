package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: SerializedSubscriber.java */
/* renamed from: औ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4056<T> implements InterfaceC3899<T>, Subscription {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Subscriber<? super T> f14074;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f14075;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Subscription f14076;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f14077;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4741<Object> f14078;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile boolean f14079;

    public C4056(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f14076.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f14079) {
            return;
        }
        synchronized (this) {
            if (this.f14079) {
                return;
            }
            if (!this.f14077) {
                this.f14079 = true;
                this.f14077 = true;
                this.f14074.onComplete();
            } else {
                C4741<Object> c4741 = this.f14078;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f14078 = c4741;
                }
                c4741.m14282(NotificationLite.complete());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f14079) {
            C3671.m11803(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f14079) {
                if (this.f14077) {
                    this.f14079 = true;
                    C4741<Object> c4741 = this.f14078;
                    if (c4741 == null) {
                        c4741 = new C4741<>(4);
                        this.f14078 = c4741;
                    }
                    Object objError = NotificationLite.error(th);
                    if (this.f14075) {
                        c4741.m14282(objError);
                    } else {
                        c4741.m14284(objError);
                    }
                    return;
                }
                this.f14079 = true;
                this.f14077 = true;
                z = false;
            }
            if (z) {
                C3671.m11803(th);
            } else {
                this.f14074.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f14079) {
            return;
        }
        if (t == null) {
            this.f14076.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f14079) {
                return;
            }
            if (!this.f14077) {
                this.f14077 = true;
                this.f14074.onNext(t);
                m12979();
            } else {
                C4741<Object> c4741 = this.f14078;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f14078 = c4741;
                }
                c4741.m14282(NotificationLite.next(t));
            }
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f14076, subscription)) {
            this.f14076 = subscription;
            this.f14074.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.f14076.request(j);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12979() {
        C4741<Object> c4741;
        do {
            synchronized (this) {
                c4741 = this.f14078;
                if (c4741 == null) {
                    this.f14077 = false;
                    return;
                }
                this.f14078 = null;
            }
        } while (!c4741.m14281(this.f14074));
    }

    public C4056(Subscriber<? super T> subscriber, boolean z) {
        this.f14074 = subscriber;
        this.f14075 = z;
    }
}
