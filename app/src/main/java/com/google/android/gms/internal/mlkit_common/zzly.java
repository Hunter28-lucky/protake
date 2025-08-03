package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzly {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    @WorkerThread
    public static zzim zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzlo zzloVar) {
        ModelType modelTypeZzb = zzloVar.zzb();
        String modelHash = remoteModel.getModelHash();
        zzis zzisVar = new zzis();
        zzin zzinVar = new zzin();
        zzinVar.zzc(remoteModel.getModelNameForBackend());
        zzinVar.zzd(zzip.CLOUD);
        zzinVar.zza(zzad.zzb(modelHash));
        int iOrdinal = modelTypeZzb.ordinal();
        zzinVar.zzb(iOrdinal != 2 ? iOrdinal != 4 ? iOrdinal != 5 ? zzio.TYPE_UNKNOWN : zzio.BASE_DIGITAL_INK : zzio.CUSTOM : zzio.BASE_TRANSLATE);
        zzisVar.zzb(zzinVar.zzg());
        zziv zzivVarZzc = zzisVar.zzc();
        zzij zzijVar = new zzij();
        zzijVar.zzd(zzloVar.zzc());
        zzijVar.zzc(zzloVar.zzd());
        zzijVar.zzb(Long.valueOf(zzloVar.zza()));
        zzijVar.zzf(zzivVarZzc);
        if (zzloVar.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzijVar.zzg(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzloVar.zzf()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzijVar.zze(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zzijVar.zzi();
    }
}
