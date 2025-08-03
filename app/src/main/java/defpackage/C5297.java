package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableError.java */
/* renamed from: ჩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5297<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends Throwable> f17489;

    public C5297(Callable<? extends Throwable> callable) {
        this.f17489 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) C4246.m13353(this.f17489.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4089.m13026(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
