package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: BasicFuseableSubscriber.java */
/* renamed from: ၺ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC5179<T, R> implements InterfaceC3899<T>, InterfaceC2968<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Subscriber<? super R> f17145;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Subscription f17146;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC2968<T> f17147;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f17148;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f17149;

    public AbstractC5179(Subscriber<? super R> subscriber) {
        this.f17145 = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f17146.cancel();
    }

    public void clear() {
        this.f17147.clear();
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return this.f17147.isEmpty();
    }

    @Override // defpackage.InterfaceC4851
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f17148) {
            return;
        }
        this.f17148 = true;
        this.f17145.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f17148) {
            C3671.m11803(th);
        } else {
            this.f17148 = true;
            this.f17145.onError(th);
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17146, subscription)) {
            this.f17146 = subscription;
            if (subscription instanceof InterfaceC2968) {
                this.f17147 = (InterfaceC2968) subscription;
            }
            if (m15127()) {
                this.f17145.onSubscribe(this);
                m15126();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.f17146.request(j);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15126() {
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m15127() {
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m15128(Throwable th) {
        C4089.m13026(th);
        this.f17146.cancel();
        onError(th);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m15129(int i) {
        InterfaceC2968<T> interfaceC2968 = this.f17147;
        if (interfaceC2968 == null || (i & 4) != 0) {
            return 0;
        }
        int iMo6310 = interfaceC2968.mo6310(i);
        if (iMo6310 != 0) {
            this.f17149 = iMo6310;
        }
        return iMo6310;
    }
}
