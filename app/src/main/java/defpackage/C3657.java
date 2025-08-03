package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Builders.common.kt */
/* renamed from: ܕ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3657<T> extends C4470<T> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f12674 = AtomicIntegerFieldUpdater.newUpdater(C3657.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public C3657(CoroutineContext coroutineContext, InterfaceC4355<? super T> interfaceC4355) {
        super(coroutineContext, interfaceC4355);
        this._decision = 0;
    }

    @Override // defpackage.C4470, defpackage.C2680
    /* renamed from: ވ */
    public void mo9840(Object obj) {
        mo6049(obj);
    }

    @Override // defpackage.C4470, defpackage.AbstractC3173
    /* renamed from: ࢧ */
    public void mo6049(Object obj) {
        if (m11742()) {
            return;
        }
        C2946.m10350(IntrinsicsKt__IntrinsicsJvmKt.m7255(this.f15372), C2609.m9541(obj, this.f15372), null, 2, null);
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public final Object m11741() {
        if (m11743()) {
            return C5199.m15170();
        }
        Object objM13735 = C4479.m13735(m9858());
        if (objM13735 instanceof C2823) {
            throw ((C2823) objM13735).f10293;
        }
        return objM13735;
    }

    /* renamed from: ࢬ, reason: contains not printable characters */
    public final boolean m11742() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f12674.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: ࢭ, reason: contains not printable characters */
    public final boolean m11743() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f12674.compareAndSet(this, 0, 1));
        return true;
    }
}
