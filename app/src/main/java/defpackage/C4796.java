package defpackage;

import io.reactivex.disposables.C1972;
import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable.java */
/* renamed from: ඛ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4796<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends T> f16270;

    public C4796(Callable<? extends T> callable) {
        this.f16270 = callable;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        InterfaceC4478 interfaceC4478M6300 = C1972.m6300();
        interfaceC4782.onSubscribe(interfaceC4478M6300);
        if (interfaceC4478M6300.isDisposed()) {
            return;
        }
        try {
            a aVar = (Object) C4246.m13353(this.f16270.call(), "The callable returned a null value");
            if (interfaceC4478M6300.isDisposed()) {
                return;
            }
            interfaceC4782.onSuccess(aVar);
        } catch (Throwable th) {
            C4089.m13026(th);
            if (interfaceC4478M6300.isDisposed()) {
                C3671.m11803(th);
            } else {
                interfaceC4782.onError(th);
            }
        }
    }
}
