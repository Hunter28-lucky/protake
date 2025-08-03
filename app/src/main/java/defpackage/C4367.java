package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: FlowableSerialized.java */
/* renamed from: ષ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4367<T> extends AbstractC3232<T, T> {
    public C4367(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C4056(subscriber));
    }
}
