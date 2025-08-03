package defpackage;

import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableJust.java */
/* renamed from: ۋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3631<T> extends AbstractC3630<T> implements InterfaceCallableC5143<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T f12588;

    public C3631(T t) {
        this.f12588 = t;
    }

    @Override // defpackage.InterfaceCallableC5143, java.util.concurrent.Callable
    public T call() {
        return this.f12588;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.f12588));
    }
}
