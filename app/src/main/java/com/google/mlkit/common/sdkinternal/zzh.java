package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
enum zzh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
