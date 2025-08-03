package defpackage;

/* compiled from: ObservableLift.java */
/* renamed from: ო, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5280<R, T> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4312<? extends R, ? super T> f17462;

    public C5280(InterfaceC2856<T> interfaceC2856, InterfaceC4312<? extends R, ? super T> interfaceC4312) {
        super(interfaceC2856);
        this.f17462 = interfaceC4312;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        try {
            this.f11778.subscribe((InterfaceC5102) C4246.m13353(this.f17462.m13454(interfaceC5102), "Operator " + this.f17462 + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
