package defpackage;

/* compiled from: ObservableDoOnLifecycle.java */
/* renamed from: љ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2927<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super InterfaceC4478> f10633;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f10634;

    public C2927(AbstractC4262<T> abstractC4262, InterfaceC2857<? super InterfaceC4478> interfaceC2857, InterfaceC3809 interfaceC3809) {
        super(abstractC4262);
        this.f10633 = interfaceC2857;
        this.f10634 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3219(interfaceC5102, this.f10633, this.f10634));
    }
}
