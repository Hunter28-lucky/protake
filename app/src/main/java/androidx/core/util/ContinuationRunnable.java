package androidx.core.util;

import defpackage.C3921;
import defpackage.InterfaceC4355;
import defpackage.i4;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* compiled from: Runnable.kt */
/* loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final InterfaceC4355<i4> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(InterfaceC4355<? super i4> interfaceC4355) {
        super(false);
        C3921.m12666(interfaceC4355, "continuation");
        this.continuation = interfaceC4355;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            InterfaceC4355<i4> interfaceC4355 = this.continuation;
            Result.C2137 c2137 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(i4.f6762));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
