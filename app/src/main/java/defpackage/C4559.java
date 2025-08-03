package defpackage;

/* compiled from: ObservableFromUnsafeSource.java */
/* renamed from: వ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4559<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15598;

    public C4559(InterfaceC2856<T> interfaceC2856) {
        this.f15598 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f15598.subscribe(interfaceC5102);
    }
}
