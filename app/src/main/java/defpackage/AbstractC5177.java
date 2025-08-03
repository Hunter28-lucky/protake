package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* renamed from: ၸ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC5177<T, R> implements InterfaceC2697<T>, InterfaceC2968<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2697<? super R> f17135;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Subscription f17136;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC2968<T> f17137;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f17138;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f17139;

    public AbstractC5177(InterfaceC2697<? super R> interfaceC2697) {
        this.f17135 = interfaceC2697;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f17136.cancel();
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
        this.f17137.clear();
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return this.f17137.isEmpty();
    }

    @Override // defpackage.InterfaceC4851
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f17138) {
            return;
        }
        this.f17138 = true;
        this.f17135.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f17138) {
            C3671.m11803(th);
        } else {
            this.f17138 = true;
            this.f17135.onError(th);
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f17136, subscription)) {
            this.f17136 = subscription;
            if (subscription instanceof InterfaceC2968) {
                this.f17137 = (InterfaceC2968) subscription;
            }
            if (m15119()) {
                this.f17135.onSubscribe(this);
                m15118();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.f17136.request(j);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15118() {
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m15119() {
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m15120(Throwable th) {
        C4089.m13026(th);
        this.f17136.cancel();
        onError(th);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m15121(int i) {
        InterfaceC2968<T> interfaceC2968 = this.f17137;
        if (interfaceC2968 == null || (i & 4) != 0) {
            return 0;
        }
        int iMo6310 = interfaceC2968.mo6310(i);
        if (iMo6310 != 0) {
            this.f17139 = iMo6310;
        }
        return iMo6310;
    }
}
