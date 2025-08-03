package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* renamed from: ௹, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4495<T> implements InterfaceC4782<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4478> f15407;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4782<? super T> f15408;

    public C4495(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4782<? super T> interfaceC4782) {
        this.f15407 = atomicReference;
        this.f15408 = interfaceC4782;
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        this.f15408.onError(th);
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.replace(this.f15407, interfaceC4478);
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        this.f15408.onSuccess(t);
    }
}
