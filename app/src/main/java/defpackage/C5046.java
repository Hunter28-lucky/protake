package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: CompletableToFlowable.java */
/* renamed from: མ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5046<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f16818;

    public C5046(InterfaceC2837 interfaceC2837) {
        this.f16818 = interfaceC2837;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f16818.mo10180(new l0(subscriber));
    }
}
