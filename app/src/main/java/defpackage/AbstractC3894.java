package defpackage;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

/* compiled from: QueueDrainSubscriber.java */
/* renamed from: ࠉ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3894<T, U, V> extends C4138 implements InterfaceC3899<T>, InterfaceC2541<U, V> {

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Subscriber<? super V> f13474;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2475<U> f13475;

    /* renamed from: ԯ, reason: contains not printable characters */
    public volatile boolean f13476;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile boolean f13477;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Throwable f13478;

    public AbstractC3894(Subscriber<? super V> subscriber, InterfaceC2475<U> interfaceC2475) {
        this.f13474 = subscriber;
        this.f13475 = interfaceC2475;
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: Ϳ */
    public final boolean mo9360() {
        return this.f13477;
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: Ԩ */
    public final boolean mo9361() {
        return this.f13476;
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: ԩ */
    public final Throwable mo9362() {
        return this.f13478;
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: Ԫ */
    public final int mo9363(int i) {
        return this.f17043.addAndGet(i);
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: ԫ */
    public final long mo9364() {
        return this.f10315.get();
    }

    /* renamed from: Ԭ */
    public boolean mo9365(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    @Override // defpackage.InterfaceC2541
    /* renamed from: Ԯ */
    public final long mo9366(long j) {
        return this.f10315.addAndGet(-j);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m12561() {
        return this.f17043.getAndIncrement() == 0;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m12562() {
        return this.f17043.get() == 0 && this.f17043.compareAndSet(0, 1);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m12563(U u, boolean z, InterfaceC4478 interfaceC4478) {
        Subscriber<? super V> subscriber = this.f13474;
        InterfaceC2475<U> interfaceC2475 = this.f13475;
        if (m12562()) {
            long j = this.f10315.get();
            if (j == 0) {
                interfaceC4478.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (mo9365(subscriber, u) && j != Long.MAX_VALUE) {
                    mo9366(1L);
                }
                if (mo9363(-1) == 0) {
                    return;
                }
            }
        } else {
            interfaceC2475.offer(u);
            if (!m12561()) {
                return;
            }
        }
        C5263.m15306(interfaceC2475, subscriber, z, interfaceC4478, this);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m12564(U u, boolean z, InterfaceC4478 interfaceC4478) {
        Subscriber<? super V> subscriber = this.f13474;
        InterfaceC2475<U> interfaceC2475 = this.f13475;
        if (m12562()) {
            long j = this.f10315.get();
            if (j == 0) {
                this.f13476 = true;
                interfaceC4478.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (interfaceC2475.isEmpty()) {
                if (mo9365(subscriber, u) && j != Long.MAX_VALUE) {
                    mo9366(1L);
                }
                if (mo9363(-1) == 0) {
                    return;
                }
            } else {
                interfaceC2475.offer(u);
            }
        } else {
            interfaceC2475.offer(u);
            if (!m12561()) {
                return;
            }
        }
        C5263.m15306(interfaceC2475, subscriber, z, interfaceC4478, this);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m12565(long j) {
        if (SubscriptionHelper.validate(j)) {
            C5153.m15069(this.f10315, j);
        }
    }
}
