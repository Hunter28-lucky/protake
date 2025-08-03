package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzt implements Closeable {
    public final /* synthetic */ TaskQueue zza;

    public /* synthetic */ zzt(TaskQueue taskQueue, zzs zzsVar) {
        this.zza = taskQueue;
        Preconditions.checkState(((Thread) taskQueue.zzd.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.zzd.set(null);
        this.zza.zzc();
    }
}
