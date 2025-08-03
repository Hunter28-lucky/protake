package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_common.zzie;
import com.google.android.gms.internal.mlkit_common.zzik;
import com.google.android.gms.internal.mlkit_common.zzld;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzln;
import com.google.android.gms.internal.mlkit_common.zzlo;
import com.google.android.gms.internal.mlkit_common.zzlp;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@WorkerThread
/* loaded from: classes2.dex */
final class zzd extends BroadcastReceiver {
    public final /* synthetic */ RemoteModelDownloadManager zza;
    private final long zzb;
    private final TaskCompletionSource zzc;

    public /* synthetic */ zzd(RemoteModelDownloadManager remoteModelDownloadManager, long j, TaskCompletionSource taskCompletionSource, zzc zzcVar) {
        this.zza = remoteModelDownloadManager;
        this.zzb = j;
        this.zzc = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        if (longExtra != this.zzb) {
            return;
        }
        Integer downloadingModelStatusCode = this.zza.getDownloadingModelStatusCode();
        synchronized (this.zza) {
            try {
                this.zza.zze.getApplicationContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                RemoteModelDownloadManager.zza.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e2);
            }
            this.zza.zzc.remove(this.zzb);
            this.zza.zzd.remove(this.zzb);
        }
        if (downloadingModelStatusCode != null) {
            if (downloadingModelStatusCode.intValue() == 16) {
                zzlm zzlmVar = this.zza.zzi;
                zzld zzldVarZzg = zzlp.zzg();
                RemoteModelDownloadManager remoteModelDownloadManager = this.zza;
                RemoteModel remoteModel = remoteModelDownloadManager.zzg;
                Long lValueOf = Long.valueOf(longExtra);
                zzlmVar.zze(zzldVarZzg, remoteModel, false, remoteModelDownloadManager.getFailureReason(lValueOf));
                this.zzc.setException(this.zza.zzl(lValueOf));
                return;
            }
            if (downloadingModelStatusCode.intValue() == 8) {
                zzlm zzlmVar2 = this.zza.zzi;
                zzld zzldVarZzg2 = zzlp.zzg();
                RemoteModel remoteModel2 = this.zza.zzg;
                zzln zzlnVarZzh = zzlo.zzh();
                zzlnVarZzh.zzb(zzie.NO_ERROR);
                zzlnVarZzh.zze(true);
                zzlnVarZzh.zzd(this.zza.zzg.getModelType());
                zzlnVarZzh.zza(zzik.SUCCEEDED);
                zzlmVar2.zzg(zzldVarZzg2, remoteModel2, zzlnVarZzh.zzh());
                this.zzc.setResult(null);
                return;
            }
        }
        this.zza.zzi.zze(zzlp.zzg(), this.zza.zzg, false, 0);
        this.zzc.setException(new MlKitException("Model downloading failed", 13));
    }
}
