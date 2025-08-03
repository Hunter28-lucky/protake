package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableDefer.java */
/* renamed from: ԑ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3150<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends Publisher<? extends T>> f11183;

    public C3150(Callable<? extends Publisher<? extends T>> callable) {
        this.f11183 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Publisher) C4246.m13353(this.f11183.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
