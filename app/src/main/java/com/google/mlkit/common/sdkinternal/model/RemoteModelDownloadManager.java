package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzie;
import com.google.android.gms.internal.mlkit_common.zzik;
import com.google.android.gms.internal.mlkit_common.zzld;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzlp;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class RemoteModelDownloadManager {
    private static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");

    @GuardedBy("RemoteModelDownloadManager.class")
    private static final Map zzb = new HashMap();

    @GuardedBy("this")
    private final LongSparseArray zzc = new LongSparseArray();

    @GuardedBy("this")
    private final LongSparseArray zzd = new LongSparseArray();
    private final MlKitContext zze;

    @Nullable
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzlm zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;

    @Nullable
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    @VisibleForTesting
    public RemoteModelDownloadManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop, @NonNull zzlm zzlmVar) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzlmVar;
        if (downloadManager == null) {
            zza.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelDownloadManager getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        Map map;
        map = zzb;
        if (!map.containsKey(remoteModel)) {
            map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzlx.zzb("common")));
        }
        return (RemoteModelDownloadManager) map.get(remoteModel);
    }

    private final Task zzj(long j) {
        this.zze.getApplicationContext().registerReceiver(zzm(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler());
        return zzk(j).getTask();
    }

    private final synchronized TaskCompletionSource zzk(long j) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get(j);
        if (taskCompletionSource != null) {
            return taskCompletionSource;
        }
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.zzd.put(j, taskCompletionSource2);
        return taskCompletionSource2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException zzl(@Nullable Long l) {
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        int i = 13;
        String string = "Model downloading failed";
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("reason"));
            if (i2 == 1006) {
                i = 101;
                string = "Model downloading failed due to insufficient space on the device.";
            } else {
                StringBuilder sb = new StringBuilder(84);
                sb.append("Model downloading failed due to error code: ");
                sb.append(i2);
                sb.append(" from Android DownloadManager");
                string = sb.toString();
            }
        }
        return new MlKitException(string, i);
    }

    private final synchronized zzd zzm(long j) {
        zzd zzdVar = (zzd) this.zzc.get(j);
        if (zzdVar != null) {
            return zzdVar;
        }
        zzd zzdVar2 = new zzd(this, j, zzk(j), null);
        this.zzc.put(j, zzdVar2);
        return zzdVar2;
    }

    @Nullable
    private final synchronized Long zzn(@NonNull DownloadManager.Request request, @NonNull ModelInfo modelInfo) {
        DownloadManager downloadManager = this.zzf;
        if (downloadManager == null) {
            return null;
        }
        long jEnqueue = downloadManager.enqueue(request);
        GmsLogger gmsLogger = zza;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Schedule a new downloading task: ");
        sb.append(jEnqueue);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        this.zzj.setDownloadingModelInfo(jEnqueue, modelInfo);
        this.zzi.zzf(zzlp.zzg(), this.zzg, zzie.NO_ERROR, false, modelInfo.getModelType(), zzik.SCHEDULED);
        return Long.valueOf(jEnqueue);
    }

    @Nullable
    @WorkerThread
    private final synchronized Long zzo(@NonNull ModelInfo modelInfo, @NonNull DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
            Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
            if (downloadingModelStatusCode2 == null || (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16)) {
                zzlm zzlmVar = this.zzi;
                zzld zzldVarZzg = zzlp.zzg();
                RemoteModel remoteModel = this.zzg;
                zzlmVar.zzf(zzldVarZzg, remoteModel, zzie.NO_ERROR, false, remoteModel.getModelType(), zzik.DOWNLOADING);
            }
            zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
            return null;
        }
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
        removeOrCancelDownload();
        DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
        if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
            gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
            this.zzi.zzf(zzlp.zzg(), this.zzg, zzie.NO_ERROR, false, modelInfo.getModelType(), zzik.UPDATE_AVAILABLE);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            request.setRequiresCharging(downloadConditions.isChargingRequired());
        }
        if (downloadConditions.isWifiRequired()) {
            request.setAllowedNetworkTypes(2);
        }
        return zzn(request, modelInfo);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public Task<Void> ensureModelDownloaded() {
        MlKitException mlKitException;
        ModelInfo modelInfoZzg;
        this.zzi.zzf(zzlp.zzg(), this.zzg, zzie.NO_ERROR, false, ModelType.UNKNOWN, zzik.EXPLICITLY_REQUESTED);
        Long lZzo = null;
        try {
            modelInfoZzg = zzg();
            mlKitException = null;
        } catch (MlKitException e2) {
            mlKitException = e2;
            modelInfoZzg = null;
        }
        try {
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            Long downloadingId = getDownloadingId();
            if (!modelExistsLocally() && (downloadingModelStatusCode == null || downloadingModelStatusCode.intValue() != 8)) {
                if (downloadingModelStatusCode != null && downloadingModelStatusCode.intValue() == 16) {
                    MlKitException mlKitExceptionZzl = zzl(downloadingId);
                    removeOrCancelDownload();
                    return Tasks.forException(mlKitExceptionZzl);
                }
                if (downloadingModelStatusCode == null || (!(downloadingModelStatusCode.intValue() == 4 || downloadingModelStatusCode.intValue() == 2 || downloadingModelStatusCode.intValue() == 1) || downloadingId == null || getDownloadingModelHash() == null)) {
                    if (modelInfoZzg != null) {
                        lZzo = zzo(modelInfoZzg, this.zzn);
                    }
                    return lZzo == null ? Tasks.forException(new MlKitException("Failed to schedule the download task", 13, mlKitException)) : zzj(lZzo.longValue());
                }
                zzlm zzlmVar = this.zzi;
                zzld zzldVarZzg = zzlp.zzg();
                RemoteModel remoteModel = this.zzg;
                zzlmVar.zzf(zzldVarZzg, remoteModel, zzie.NO_ERROR, false, remoteModel.getModelType(), zzik.DOWNLOADING);
                return zzj(downloadingId.longValue());
            }
            if (modelInfoZzg != null) {
                Long lZzo2 = zzo(modelInfoZzg, this.zzn);
                if (lZzo2 != null) {
                    return zzj(lZzo2.longValue());
                }
                zza.i("ModelDownloadManager", "Didn't schedule download for the updated model");
            }
            return Tasks.forResult(null);
        } catch (MlKitException e3) {
            return Tasks.forException(new MlKitException("Failed to ensure the model is downloaded.", 13, e3));
        }
    }

    @Nullable
    @KeepForSdk
    public synchronized ParcelFileDescriptor getDownloadedFile() {
        Long downloadingId = getDownloadingId();
        DownloadManager downloadManager = this.zzf;
        ParcelFileDescriptor parcelFileDescriptorOpenDownloadedFile = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptorOpenDownloadedFile = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            zza.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptorOpenDownloadedFile;
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingId() {
        return this.zzj.getDownloadingModelId(this.zzg);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash() {
        return this.zzj.getDownloadingModelHash(this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Long r0 = r8.getDownloadingId()     // Catch: java.lang.Throwable -> L90
            android.app.DownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> L90
            r2 = 0
            if (r1 == 0) goto L8e
            if (r0 != 0) goto Le
            goto L8e
        Le:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch: java.lang.Throwable -> L90
            r3.<init>()     // Catch: java.lang.Throwable -> L90
            r4 = 1
            long[] r5 = new long[r4]     // Catch: java.lang.Throwable -> L90
            long r6 = r0.longValue()     // Catch: java.lang.Throwable -> L90
            r0 = 0
            r5[r0] = r6     // Catch: java.lang.Throwable -> L90
            android.app.DownloadManager$Query r3 = r3.setFilterById(r5)     // Catch: java.lang.Throwable -> L90
            android.database.Cursor r1 = r1.query(r3)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L3e
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            java.lang.String r3 = "status"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r2 = move-exception
            goto L73
        L3e:
            r3 = r2
        L3f:
            if (r3 != 0) goto L48
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.lang.Throwable -> L90
        L46:
            monitor-exit(r8)
            return r2
        L48:
            int r5 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r6 = 2
            if (r5 == r6) goto L6d
            int r5 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r6 = 4
            if (r5 == r6) goto L6d
            int r5 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            if (r5 == r4) goto L6d
            int r5 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r6 = 8
            if (r5 == r6) goto L6d
            int r0 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 16
            if (r0 == r4) goto L6d
            goto L6e
        L6d:
            r2 = r3
        L6e:
            r1.close()     // Catch: java.lang.Throwable -> L90
            monitor-exit(r8)
            return r2
        L73:
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L8d
        L77:
            r1 = move-exception
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            r3[r0] = r5     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            java.lang.String r6 = "addSuppressed"
            java.lang.reflect.Method r3 = r5.getDeclaredMethod(r6, r3)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
            r4[r0] = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L90
        L8d:
            throw r2     // Catch: java.lang.Throwable -> L90
        L8e:
            monitor-exit(r8)
            return r2
        L90:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    @KeepForSdk
    public int getFailureReason(@NonNull Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return cursorQuery.getInt(columnIndex);
    }

    @KeepForSdk
    @WorkerThread
    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        zza.d("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(downloadingModelStatusCode)));
        if (downloadingModelStatusCode != null) {
            return Objects.equal(downloadingModelStatusCode, 8) && zzi(downloadingModelHash) != null;
        }
        removeOrCancelDownload();
        return false;
    }

    @KeepForSdk
    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    @KeepForSdk
    public synchronized void removeOrCancelDownload() throws MlKitException {
        Long downloadingId = getDownloadingId();
        if (this.zzf != null && downloadingId != null) {
            zza.d("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(downloadingId.toString()));
            if (this.zzf.remove(downloadingId.longValue()) > 0 || getDownloadingModelStatusCode() == null) {
                this.zzk.deleteTempFilesInPrivateFolder(this.zzg.getUniqueModelNameForPersist(), this.zzg.getModelType());
                this.zzj.clearDownloadingModelInfo(this.zzg);
            }
        }
    }

    @KeepForSdk
    public void setDownloadConditions(@NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    @KeepForSdk
    public synchronized void updateLatestModelHashAndType(@NonNull String str) throws MlKitException {
        this.zzj.setLatestModelHash(this.zzg, str);
        removeOrCancelDownload();
    }

    @Nullable
    @WorkerThread
    public final synchronized ModelInfo zzg() throws MlKitException {
        boolean z;
        boolean zModelExistsLocally = modelExistsLocally();
        if (zModelExistsLocally) {
            zzlm zzlmVar = this.zzi;
            zzld zzldVarZzg = zzlp.zzg();
            RemoteModel remoteModel = this.zzg;
            zzlmVar.zzf(zzldVarZzg, remoteModel, zzie.NO_ERROR, false, remoteModel.getModelType(), zzik.LIVE);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.zzl;
        if (modelInfoRetrieverInterop == null) {
            throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
        }
        ModelInfo modelInfoRetrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.zzg);
        if (modelInfoRetrieveRemoteModelInfo == null) {
            return null;
        }
        MlKitContext mlKitContext = this.zze;
        RemoteModel remoteModel2 = this.zzg;
        String modelHash = modelInfoRetrieveRemoteModelInfo.getModelHash();
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
        boolean zEquals = modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel2));
        boolean z2 = false;
        if (zEquals && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(sharedPrefManager.getPreviousAppVersion())) {
            zza.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
            z = false;
        } else {
            z = true;
        }
        if (!zModelExistsLocally) {
            this.zzj.clearLatestModelHash(this.zzg);
        }
        boolean z3 = !modelInfoRetrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.zze).getLatestModelHash(this.zzg));
        if (!z) {
            z2 = z3;
        } else if (!zModelExistsLocally || z3) {
            return modelInfoRetrieveRemoteModelInfo;
        }
        if (zModelExistsLocally && (z2 ^ z)) {
            return null;
        }
        String modelName = this.zzg.getModelName();
        StringBuilder sb = new StringBuilder(String.valueOf(modelName).length() + 46);
        sb.append("The model ");
        sb.append(modelName);
        sb.append(" is incompatible with TFLite runtime");
        throw new MlKitException(sb.toString(), 100);
    }

    @Nullable
    public final File zzi(@NonNull String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zzf(zzlp.zzg(), this.zzg, zzie.NO_ERROR, true, this.zzh, zzik.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }
}
