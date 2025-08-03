package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableAutoConnect.java */
/* renamed from: ದ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4630<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4945<? extends T> f15757;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f15758;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super InterfaceC4478> f15759;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AtomicInteger f15760 = new AtomicInteger();

    public C4630(AbstractC4945<? extends T> abstractC4945, int i, InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        this.f15757 = abstractC4945;
        this.f15758 = i;
        this.f15759 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f15757.subscribe((InterfaceC5102<? super Object>) interfaceC5102);
        if (this.f15760.incrementAndGet() == this.f15758) {
            this.f15757.mo6834(this.f15759);
        }
    }
}
