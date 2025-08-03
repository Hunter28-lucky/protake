package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableEmpty.java */
/* renamed from: য, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4197 extends AbstractC3630<Object> implements InterfaceCallableC5143<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC3630<Object> f14472 = new C4197();

    @Override // defpackage.InterfaceCallableC5143, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
