package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: SingleNever.java */
/* renamed from: ඍ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4781 extends AbstractC4838<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC4838<Object> f16120 = new C4781();

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Object> interfaceC4782) {
        interfaceC4782.onSubscribe(EmptyDisposable.NEVER);
    }
}
