package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
enum zzbb implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
