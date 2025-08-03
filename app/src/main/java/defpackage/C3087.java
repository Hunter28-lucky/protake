package defpackage;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableFromFuture.java */
/* renamed from: ҹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3087<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Future<? extends T> f10970;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f10971;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f10972;

    public C3087(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f10970 = future;
        this.f10971 = j;
        this.f10972 = timeUnit;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f10972;
            T t = timeUnit != null ? this.f10970.get(this.f10971, timeUnit) : this.f10970.get();
            if (t == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.m7008(t);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            if (deferredScalarSubscription.m7009()) {
                return;
            }
            subscriber.onError(th);
        }
    }
}
