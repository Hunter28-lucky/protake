package defpackage;

import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: SerializedProcessor.java */
/* renamed from: ಝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4620<T> extends AbstractC2892<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC2892<T> f15738;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f15739;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4741<Object> f15740;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f15741;

    public C4620(AbstractC2892<T> abstractC2892) {
        this.f15738 = abstractC2892;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f15741) {
            return;
        }
        synchronized (this) {
            if (this.f15741) {
                return;
            }
            this.f15741 = true;
            if (!this.f15739) {
                this.f15739 = true;
                this.f15738.onComplete();
                return;
            }
            C4741<Object> c4741 = this.f15740;
            if (c4741 == null) {
                c4741 = new C4741<>(4);
                this.f15740 = c4741;
            }
            c4741.m14282(NotificationLite.complete());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f15741) {
            C3671.m11803(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f15741) {
                this.f15741 = true;
                if (this.f15739) {
                    C4741<Object> c4741 = this.f15740;
                    if (c4741 == null) {
                        c4741 = new C4741<>(4);
                        this.f15740 = c4741;
                    }
                    c4741.m14284(NotificationLite.error(th));
                    return;
                }
                this.f15739 = true;
                z = false;
            }
            if (z) {
                C3671.m11803(th);
            } else {
                this.f15738.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f15741) {
            return;
        }
        synchronized (this) {
            if (this.f15741) {
                return;
            }
            if (!this.f15739) {
                this.f15739 = true;
                this.f15738.onNext(t);
                m14075();
            } else {
                C4741<Object> c4741 = this.f15740;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f15740 = c4741;
                }
                c4741.m14282(NotificationLite.next(t));
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.f15741) {
            synchronized (this) {
                if (!this.f15741) {
                    if (this.f15739) {
                        C4741<Object> c4741 = this.f15740;
                        if (c4741 == null) {
                            c4741 = new C4741<>(4);
                            this.f15740 = c4741;
                        }
                        c4741.m14282(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.f15739 = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
        } else {
            this.f15738.onSubscribe(subscription);
            m14075();
        }
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f15738.subscribe(subscriber);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m14075() {
        C4741<Object> c4741;
        while (true) {
            synchronized (this) {
                c4741 = this.f15740;
                if (c4741 == null) {
                    this.f15739 = false;
                    return;
                }
                this.f15740 = null;
            }
            c4741.m14281(this.f15738);
        }
    }
}
