package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Scopes.kt */
/* renamed from: ஜ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4470<T> extends AbstractC3173<T> implements InterfaceC4472 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC4355<T> f15372;

    /* JADX WARN: Multi-variable type inference failed */
    public C4470(CoroutineContext coroutineContext, InterfaceC4355<? super T> interfaceC4355) {
        super(coroutineContext, true, true);
        this.f15372 = interfaceC4355;
    }

    @Override // defpackage.InterfaceC4472
    public final InterfaceC4472 getCallerFrame() {
        InterfaceC4355<T> interfaceC4355 = this.f15372;
        if (interfaceC4355 instanceof InterfaceC4472) {
            return (InterfaceC4472) interfaceC4355;
        }
        return null;
    }

    @Override // defpackage.C2680
    /* renamed from: ވ */
    public void mo9840(Object obj) {
        C2946.m10350(IntrinsicsKt__IntrinsicsJvmKt.m7255(this.f15372), C2609.m9541(obj, this.f15372), null, 2, null);
    }

    @Override // defpackage.C2680
    /* renamed from: ޢ */
    public final boolean mo9864() {
        return true;
    }

    @Override // defpackage.AbstractC3173
    /* renamed from: ࢧ */
    public void mo6049(Object obj) {
        InterfaceC4355<T> interfaceC4355 = this.f15372;
        interfaceC4355.resumeWith(C2609.m9541(obj, interfaceC4355));
    }
}
