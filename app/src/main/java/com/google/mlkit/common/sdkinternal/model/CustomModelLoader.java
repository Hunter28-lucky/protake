package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class CustomModelLoader {
    private static final GmsLogger zza = new GmsLogger("CustomModelLoader", "");

    @GuardedBy("CustomModelLoader.class")
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;

    @Nullable
    private final LocalModel zzd;

    @Nullable
    private final CustomRemoteModel zze;

    @Nullable
    private final RemoteModelDownloadManager zzf;

    @Nullable
    private final RemoteModelFileManager zzg;
    private final zzlm zzh;
    private boolean zzi;

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public interface CustomModelLoaderHelper {
        @KeepForSdk
        void logLoad() throws MlKitException;

        @KeepForSdk
        boolean tryLoad(@NonNull LocalModel localModel) throws MlKitException;
    }

    private CustomModelLoader(@NonNull MlKitContext mlKitContext, @Nullable LocalModel localModel, @Nullable CustomRemoteModel customRemoteModel) {
        if (customRemoteModel != null) {
            RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, customRemoteModel, null, new ModelFileHelper(mlKitContext), new com.google.mlkit.common.internal.model.zza(mlKitContext, customRemoteModel.getUniqueModelNameForPersist()));
            this.zzg = remoteModelFileManager;
            this.zzf = RemoteModelDownloadManager.getInstance(mlKitContext, customRemoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
            this.zzi = true;
        } else {
            this.zzg = null;
            this.zzf = null;
        }
        this.zzc = mlKitContext;
        this.zzd = localModel;
        this.zze = customRemoteModel;
        this.zzh = zzlx.zzb("common");
    }

    @NonNull
    @KeepForSdk
    public static synchronized CustomModelLoader getInstance(@NonNull MlKitContext mlKitContext, @Nullable LocalModel localModel, @Nullable CustomRemoteModel customRemoteModel) {
        String string;
        Map map;
        string = customRemoteModel == null ? ((LocalModel) Preconditions.checkNotNull(localModel)).toString() : customRemoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(string)) {
            map.put(string, new CustomModelLoader(mlKitContext, localModel, customRemoteModel));
        }
        return (CustomModelLoader) map.get(string);
    }

    @Nullable
    @WorkerThread
    private final File zza() throws MlKitException {
        String strZzb = ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzb();
        if (strZzb == null) {
            zza.d("CustomModelLoader", "No existing model file");
            return null;
        }
        File file = new File(strZzb);
        File[] fileArrListFiles = file.listFiles();
        return ((File[]) Preconditions.checkNotNull(fileArrListFiles)).length == 1 ? fileArrListFiles[0] : file;
    }

    @WorkerThread
    private final void zzb() throws MlKitException {
        ((RemoteModelDownloadManager) Preconditions.checkNotNull(this.zzf)).removeOrCancelDownload();
    }

    @WorkerThread
    private static final LocalModel zzc(File file) {
        if (file.isDirectory()) {
            LocalModel.Builder builder = new LocalModel.Builder();
            builder.setAbsoluteManifestFilePath(new File(file.getAbsolutePath(), Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME).toString());
            return builder.build();
        }
        LocalModel.Builder builder2 = new LocalModel.Builder();
        builder2.setAbsoluteFilePath(file.getAbsolutePath());
        return builder2.build();
    }

    @VisibleForTesting
    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized LocalModel createLocalModelByLatestExistingModel() throws MlKitException {
        zza.d("CustomModelLoader", "Try to get the latest existing model file.");
        File fileZza = zza();
        if (fileZza == null) {
            return null;
        }
        return zzc(fileZza);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[Catch: all -> 0x00ae, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0023, B:9:0x002b, B:28:0x00a8, B:10:0x0030, B:12:0x0047, B:15:0x0050, B:17:0x0060, B:19:0x006a, B:18:0x0065, B:20:0x0075, B:22:0x007d, B:23:0x0099), top: B:34:0x0001 }] */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.google.mlkit.common.model.LocalModel createLocalModelByNewlyDownloadedModel() throws com.google.mlkit.common.MlKitException {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.sdkinternal.model.CustomModelLoader.zza     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "Try to get newly downloaded model file."
            r0.d(r1, r2)     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = (com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager) r1     // Catch: java.lang.Throwable -> Lae
            java.lang.Long r1 = r1.getDownloadingId()     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = r2.getDownloadingModelHash()     // Catch: java.lang.Throwable -> Lae
            r3 = 0
            if (r1 == 0) goto L99
            if (r2 != 0) goto L23
            goto L99
        L23:
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r4 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r4 = r4.getDownloadingModelStatusCode()     // Catch: java.lang.Throwable -> Lae
            if (r4 != 0) goto L30
            r8.zzb()     // Catch: java.lang.Throwable -> Lae
            goto La3
        L30:
            java.lang.String r5 = "CustomModelLoader"
            java.lang.String r6 = "Download Status code: "
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.Throwable -> Lae
            r0.d(r5, r6)     // Catch: java.lang.Throwable -> Lae
            int r5 = r4.intValue()     // Catch: java.lang.Throwable -> Lae
            r6 = 8
            if (r5 != r6) goto L75
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            java.io.File r1 = r1.zzi(r2)     // Catch: java.lang.Throwable -> Lae
            if (r1 != 0) goto L50
            goto La3
        L50:
            java.lang.String r4 = r1.getParent()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "Moved the downloaded model to private folder successfully: "
            int r6 = r4.length()     // Catch: java.lang.Throwable -> Lae
            if (r6 == 0) goto L65
            java.lang.String r4 = r5.concat(r4)     // Catch: java.lang.Throwable -> Lae
            goto L6a
        L65:
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> Lae
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lae
        L6a:
            java.lang.String r5 = "CustomModelLoader"
            r0.d(r5, r4)     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r0 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            r0.updateLatestModelHashAndType(r2)     // Catch: java.lang.Throwable -> Lae
            goto La4
        L75:
            int r0 = r4.intValue()     // Catch: java.lang.Throwable -> Lae
            r2 = 16
            if (r0 != r2) goto La3
            com.google.android.gms.internal.mlkit_common.zzlm r0 = r8.zzh     // Catch: java.lang.Throwable -> Lae
            com.google.android.gms.internal.mlkit_common.zzld r2 = com.google.android.gms.internal.mlkit_common.zzlp.zzg()     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.model.CustomRemoteModel r4 = r8.zze     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch: java.lang.Throwable -> Lae
            com.google.mlkit.common.model.RemoteModel r4 = (com.google.mlkit.common.model.RemoteModel) r4     // Catch: java.lang.Throwable -> Lae
            r5 = 0
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r6 = r8.zzf     // Catch: java.lang.Throwable -> Lae
            int r1 = r6.getFailureReason(r1)     // Catch: java.lang.Throwable -> Lae
            r0.zze(r2, r4, r5, r1)     // Catch: java.lang.Throwable -> Lae
            r8.zzb()     // Catch: java.lang.Throwable -> Lae
            goto La3
        L99:
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "No new model is downloading."
            r0.d(r1, r2)     // Catch: java.lang.Throwable -> Lae
            r8.zzb()     // Catch: java.lang.Throwable -> Lae
        La3:
            r1 = r3
        La4:
            if (r1 != 0) goto La8
            monitor-exit(r8)
            return r3
        La8:
            com.google.mlkit.common.model.LocalModel r0 = zzc(r1)     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r8)
            return r0
        Lae:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.CustomModelLoader.createLocalModelByNewlyDownloadedModel():com.google.mlkit.common.model.LocalModel");
    }

    @KeepForSdk
    @VisibleForTesting
    @WorkerThread
    public void deleteLatestExistingModel() throws MlKitException {
        File fileZza = zza();
        if (fileZza != null) {
            ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzc(fileZza);
            SharedPrefManager.getInstance(this.zzc).clearLatestModelHash((RemoteModel) Preconditions.checkNotNull(this.zze));
        }
    }

    @KeepForSdk
    @VisibleForTesting
    @WorkerThread
    public void deleteOldModels(@NonNull LocalModel localModel) throws MlKitException {
        File parentFile = new File((String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath())).getParentFile();
        if (!((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzd((File) Preconditions.checkNotNull(parentFile))) {
            zza.e("CustomModelLoader", "Failed to delete old models");
        } else {
            zza.d("CustomModelLoader", "All old models are deleted.");
            this.zzg.zza(parentFile);
        }
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void load(@NonNull CustomModelLoaderHelper customModelLoaderHelper) throws MlKitException {
        LocalModel localModelCreateLocalModelByLatestExistingModel = this.zzd;
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            localModelCreateLocalModelByLatestExistingModel = createLocalModelByNewlyDownloadedModel();
        }
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
        }
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            throw new MlKitException("Model is not available.", 14);
        }
        while (!customModelLoaderHelper.tryLoad(localModelCreateLocalModelByLatestExistingModel)) {
            if (this.zze != null) {
                deleteLatestExistingModel();
                localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
            } else {
                localModelCreateLocalModelByLatestExistingModel = null;
            }
            if (localModelCreateLocalModelByLatestExistingModel == null) {
                customModelLoaderHelper.logLoad();
                return;
            }
        }
        if (this.zze != null && this.zzi) {
            deleteOldModels((LocalModel) Preconditions.checkNotNull(localModelCreateLocalModelByLatestExistingModel));
            this.zzi = false;
        }
        customModelLoaderHelper.logLoad();
    }
}
