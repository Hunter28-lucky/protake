package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: JobSupport.kt */
/* renamed from: ӛ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3111 extends AbstractC4027 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f11068 = AtomicIntegerFieldUpdater.newUpdater(C3111.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC2392<Throwable, i4> f11069;

    /* JADX WARN: Multi-variable type inference failed */
    public C3111(InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        this.f11069 = interfaceC2392;
    }

    @Override // defpackage.InterfaceC2392
    public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
        mo9888(th);
        return i4.f6762;
    }

    @Override // defpackage.AbstractC5076
    /* renamed from: ފ */
    public void mo9888(Throwable th) {
        if (f11068.compareAndSet(this, 0, 1)) {
            this.f11069.invoke(th);
        }
    }
}
