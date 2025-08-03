package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: DisposeOnCancel.java */
/* renamed from: ƾ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class FutureC2470 implements Future<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC4478 f9169;

    public FutureC2470(InterfaceC4478 interfaceC4478) {
        this.f9169 = interfaceC4478;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f9169.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
