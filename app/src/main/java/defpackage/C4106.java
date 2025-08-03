package defpackage;

/* compiled from: DelegateFactory.java */
/* renamed from: ग़, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4106<T> implements InterfaceC3628<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC4461<T> f14255;

    @Override // defpackage.InterfaceC4461
    public T get() {
        InterfaceC4461<T> interfaceC4461 = this.f14255;
        if (interfaceC4461 != null) {
            return interfaceC4461.get();
        }
        throw new IllegalStateException();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m13051(InterfaceC4461<T> interfaceC4461) {
        if (interfaceC4461 == null) {
            throw new IllegalArgumentException();
        }
        if (this.f14255 != null) {
            throw new IllegalStateException();
        }
        this.f14255 = interfaceC4461;
    }
}
