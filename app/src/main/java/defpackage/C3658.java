package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: CompletableDefer.java */
/* renamed from: ܖ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3658 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2837> f12675;

    public C3658(Callable<? extends InterfaceC2837> callable) {
        this.f12675 = callable;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        try {
            ((InterfaceC2837) C4246.m13353(this.f12675.call(), "The completableSupplier returned a null CompletableSource")).mo10180(interfaceC5053);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5053);
        }
    }
}
