package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* compiled from: DisposableSubscriber.java */
/* renamed from: ź, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2399<T> implements InterfaceC3899<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<Subscription> f8972 = new AtomicReference<>();

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        SubscriptionHelper.cancel(this.f8972);
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return this.f8972.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (C2889.m10248(this.f8972, subscription, getClass())) {
            m8891();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m8890() {
        dispose();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8891() {
        this.f8972.get().request(Long.MAX_VALUE);
    }
}
