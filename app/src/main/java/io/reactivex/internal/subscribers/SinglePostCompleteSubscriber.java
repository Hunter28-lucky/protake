package io.reactivex.internal.subscribers;

import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements InterfaceC3899<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;
    public final Subscriber<? super R> downstream;
    public long produced;
    public Subscription upstream;
    public R value;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.downstream.onNext(this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j2, C5153.m15071(j2, j)));
            this.upstream.request(j);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7006(R r) {
        long j = this.produced;
        if (j != 0) {
            C5153.m15073(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                mo6523(r);
                return;
            }
            if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    /* renamed from: Ԩ */
    public void mo6523(R r) {
    }
}
