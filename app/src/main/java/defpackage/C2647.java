package defpackage;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableFromPublisher.java */
/* renamed from: ʅ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2647<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f9853;

    public C2647(Publisher<? extends T> publisher) {
        this.f9853 = publisher;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f9853.subscribe(subscriber);
    }
}
