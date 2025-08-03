package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SerialDisposable.java */
/* renamed from: ண, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4473 implements InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4478> f15374 = new AtomicReference<>();

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this.f15374);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f15374.get());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m13727(InterfaceC4478 interfaceC4478) {
        return DisposableHelper.set(this.f15374, interfaceC4478);
    }
}
