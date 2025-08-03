package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
final class zzo implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzp zzb;

    public zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskThen = this.zzb.zzb.then(this.zza.getResult());
            if (taskThen == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzp zzpVar = this.zzb;
            Executor executor = TaskExecutors.zza;
            taskThen.addOnSuccessListener(executor, zzpVar);
            taskThen.addOnFailureListener(executor, this.zzb);
            taskThen.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzb.onFailure((Exception) e2.getCause());
            } else {
                this.zzb.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.zzb.onCanceled();
        } catch (Exception e3) {
            this.zzb.onFailure(e3);
        }
    }
}
