package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* renamed from: ৻, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4221 extends C2823 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f14515 = AtomicIntegerFieldUpdater.newUpdater(C4221.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public C4221(InterfaceC4355<?> interfaceC4355, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + interfaceC4355 + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m13309() {
        return f14515.compareAndSet(this, 0, 1);
    }
}
