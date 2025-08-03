package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: FlowableLift.java */
/* renamed from: ງ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4944<R, T> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2824<? extends R, ? super T> f16662;

    public C4944(AbstractC3630<T> abstractC3630, InterfaceC2824<? extends R, ? super T> interfaceC2824) {
        super(abstractC3630);
        this.f16662 = interfaceC2824;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super Object> subscriberM10169 = this.f16662.m10169(subscriber);
            if (subscriberM10169 != null) {
                this.f11385.subscribe(subscriberM10169);
                return;
            }
            throw new NullPointerException("Operator " + this.f16662 + " returned a null Subscriber");
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
