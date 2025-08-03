package defpackage;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableFromCallable.java */
/* renamed from: ຂ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class CallableC4940<T> extends AbstractC3630<T> implements Callable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends T> f16655;

    public CallableC4940(Callable<? extends T> callable) {
        this.f16655 = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) C4246.m13353(this.f16655.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.m7008(C4246.m13353(this.f16655.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            C4089.m13026(th);
            if (deferredScalarSubscription.m7009()) {
                C3671.m11803(th);
            } else {
                subscriber.onError(th);
            }
        }
    }
}
