package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class TaskQueue {

    @GuardedBy("lock")
    private boolean zzb;
    private final Object zza = new Object();

    @GuardedBy("lock")
    private final Queue zzc = new ArrayDeque();
    private final AtomicReference zzd = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc() {
        synchronized (this.zza) {
            if (this.zzc.isEmpty()) {
                this.zzb = false;
            } else {
                zzr zzrVar = (zzr) this.zzc.remove();
                zzd(zzrVar.zza, zzrVar.zzb);
            }
        }
    }

    private final void zzd(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzp
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    TaskQueue taskQueue = this.zza;
                    Runnable runnable2 = runnable;
                    zzt zztVar = new zzt(taskQueue, null);
                    try {
                        runnable2.run();
                        zztVar.close();
                    } catch (Throwable th) {
                        try {
                            zztVar.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            zzc();
        }
    }

    @KeepForSdk
    public void checkIsRunningOnCurrentThread() {
        Preconditions.checkState(Thread.currentThread().equals(this.zzd.get()));
    }

    @KeepForSdk
    public void submit(@NonNull Executor executor, @NonNull Runnable runnable) {
        synchronized (this.zza) {
            if (this.zzb) {
                this.zzc.add(new zzr(executor, runnable, null));
            } else {
                this.zzb = true;
                zzd(executor, runnable);
            }
        }
    }
}
