package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* renamed from: Ⴔ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5217<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends Throwable> f17275;

    public C5217(Callable<? extends Throwable> callable) {
        this.f17275 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            th = (Throwable) C4246.m13353(this.f17275.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C4089.m13026(th);
        }
        EmptyDisposable.error(th, interfaceC5102);
    }
}
