package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class ModelFileHelper {

    @KeepForSdk
    public static final int INVALID_INDEX = -1;
    private final MlKitContext zze;
    private static final GmsLogger zzd = new GmsLogger("ModelFileHelper", "");

    @NonNull
    @VisibleForTesting
    public static final String zza = String.format("com.google.mlkit.%s.models", "translate");

    @NonNull
    @VisibleForTesting
    public static final String zzb = String.format("com.google.mlkit.%s.models", "custom");

    @VisibleForTesting
    public static final String zzc = String.format("com.google.mlkit.%s.models", "base");

    public ModelFileHelper(@NonNull MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    @WorkerThread
    private final File zzc(@NonNull String str, @NonNull ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = zzd;
            String strValueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(strValueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                throw new MlKitException("Failed to create model folder: ".concat(String.valueOf(modelDirUnsafe)), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            throw new MlKitException("Can not create model folder, since an existing file has the same name: ".concat(String.valueOf(modelDirUnsafe)), 6);
        }
        return modelDirUnsafe;
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void deleteAllModels(@NonNull ModelType modelType, @NonNull String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean deleteRecursively(@androidx.annotation.Nullable java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            boolean r1 = r8.isDirectory()
            r2 = 1
            if (r1 == 0) goto L2c
            java.io.File[] r1 = r8.listFiles()
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.io.File[] r1 = (java.io.File[]) r1
            int r3 = r1.length
            r4 = r0
            r5 = r2
        L18:
            if (r4 >= r3) goto L2a
            r6 = r1[r4]
            if (r5 == 0) goto L26
            boolean r5 = r7.deleteRecursively(r6)
            if (r5 == 0) goto L26
            r5 = r2
            goto L27
        L26:
            r5 = r0
        L27:
            int r4 = r4 + 1
            goto L18
        L2a:
            if (r5 == 0) goto L33
        L2c:
            boolean r8 = r8.delete()
            if (r8 == 0) goto L33
            return r2
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.ModelFileHelper.deleteRecursively(java.io.File):boolean");
    }

    @KeepForSdk
    @WorkerThread
    public void deleteTempFilesInPrivateFolder(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (deleteRecursively(fileZzc)) {
            return;
        }
        GmsLogger gmsLogger = zzd;
        String strValueOf = String.valueOf(fileZzc != null ? fileZzc.getAbsolutePath() : null);
        gmsLogger.e("ModelFileHelper", strValueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(strValueOf) : new String("Failed to delete the temp labels file directory: "));
    }

    @KeepForSdk
    @WorkerThread
    public int getLatestCachedModelVersion(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        int iMax = -1;
        if (fileArrListFiles != null && (fileArrListFiles.length) != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    iMax = Math.max(iMax, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zzd;
                    String strValueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "Contains non-integer file name ".concat(strValueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return iMax;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelDir(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, false);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelDirUnsafe(@NonNull String str, @NonNull ModelType modelType, boolean z) {
        String str2;
        ModelType modelType2 = ModelType.UNKNOWN;
        int iOrdinal = modelType.ordinal();
        if (iOrdinal == 1) {
            str2 = zzc;
        } else if (iOrdinal == 2) {
            str2 = zza;
        } else {
            if (iOrdinal != 4) {
                String strName = modelType.name();
                StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 69);
                sb.append("Unknown model type ");
                sb.append(strName);
                sb.append(". Cannot find a dir to store the downloaded model.");
                throw new IllegalArgumentException(sb.toString());
            }
            str2 = zzb;
        }
        File file = new File(this.zze.getApplicationContext().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getModelTempDir(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File getTempFileInPrivateFolder(@NonNull String str, @NonNull ModelType modelType, @NonNull String str2) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (fileZzc.exists() && fileZzc.isFile() && !fileZzc.delete()) {
            String strValueOf = String.valueOf(fileZzc.getAbsolutePath());
            throw new MlKitException(strValueOf.length() != 0 ? "Failed to delete the temp labels file: ".concat(strValueOf) : new String("Failed to delete the temp labels file: "), 13);
        }
        if (!fileZzc.exists()) {
            GmsLogger gmsLogger = zzd;
            String strValueOf2 = String.valueOf(fileZzc.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf2.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(strValueOf2) : new String("Temp labels folder does not exist, creating one: "));
            if (!fileZzc.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(fileZzc, str2);
    }

    @KeepForSdk
    @WorkerThread
    public boolean modelExistsLocally(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        String strZzb;
        if (modelType == ModelType.UNKNOWN || (strZzb = zzb(str, modelType)) == null) {
            return false;
        }
        File file = new File(strZzb);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, Constants.MODEL_FILE_NAME);
        GmsLogger gmsLogger = zzd;
        String strValueOf = String.valueOf(file2.getAbsolutePath());
        gmsLogger.i("ModelFileHelper", strValueOf.length() != 0 ? "Model file path: ".concat(strValueOf) : new String("Model file path: "));
        return file2.exists();
    }

    @NonNull
    @WorkerThread
    public final File zza(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    @Nullable
    @WorkerThread
    public final String zzb(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }
}
