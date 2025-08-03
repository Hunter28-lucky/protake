package defpackage;

/* compiled from: ObservableSerialized.java */
/* renamed from: ჷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5313<T> extends AbstractC3414<T, T> {
    public C5313(AbstractC4262<T> abstractC4262) {
        super(abstractC4262);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C5312(interfaceC5102));
    }
}
