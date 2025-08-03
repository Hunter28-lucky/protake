package defpackage;

import org.reactivestreams.Subscription;

/* compiled from: DefaultSubscriber.java */
/* renamed from: ǰ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2496<T> implements InterfaceC3899<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Subscription f9251;

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (C2889.m10250(this.f9251, subscription, getClass())) {
            this.f9251 = subscription;
            m9205();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m9205() {
        m9206(Long.MAX_VALUE);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m9206(long j) {
        Subscription subscription = this.f9251;
        if (subscription != null) {
            subscription.request(j);
        }
    }
}
