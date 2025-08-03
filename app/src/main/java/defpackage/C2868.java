package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableNever.java */
/* renamed from: Ў, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2868 extends AbstractC3630<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC3630<Object> f10496 = new C2868();

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
