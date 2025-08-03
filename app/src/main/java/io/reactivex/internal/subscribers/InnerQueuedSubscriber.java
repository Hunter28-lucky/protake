package io.reactivex.internal.subscribers;

import defpackage.C5263;
import defpackage.InterfaceC2877;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final InterfaceC2877<T> parent;
    public final int prefetch;
    public long produced;
    public volatile InterfaceC4851<T> queue;

    public InnerQueuedSubscriber(InterfaceC2877<T> interfaceC2877, int i) {
        this.parent = interfaceC2877;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.mo6404(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.parent.mo6407(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.mo6406(this, t);
        } else {
            this.parent.mo6405();
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof InterfaceC2968) {
                InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                int iMo6310 = interfaceC2968.mo6310(3);
                if (iMo6310 == 1) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC2968;
                    this.done = true;
                    this.parent.mo6404(this);
                    return;
                }
                if (iMo6310 == 2) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC2968;
                    C5263.m15311(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = C5263.m15304(this.prefetch);
            C5263.m15311(subscription, this.prefetch);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 < this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7002() {
        return this.done;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4851<T> m7003() {
        return this.queue;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m7004() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j != this.limit) {
                this.produced = j;
            } else {
                this.produced = 0L;
                get().request(j);
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m7005() {
        this.done = true;
    }
}
