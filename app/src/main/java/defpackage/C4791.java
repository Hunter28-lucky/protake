package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: SingleError.java */
/* renamed from: ඕ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4791<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends Throwable> f16136;

    public C4791(Callable<? extends Throwable> callable) {
        this.f16136 = callable;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        try {
            th = (Throwable) C4246.m13353(this.f16136.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4089.m13026(th);
        }
        EmptyDisposable.error(th, interfaceC4782);
    }
}
