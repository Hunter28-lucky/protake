package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public abstract class LegacyModelMigrator {

    @NonNull
    @KeepForSdk
    public final ModelFileHelper modelFileHelper;
    private final Context zzb;
    private final TaskCompletionSource zza = new TaskCompletionSource();
    private final Executor zzc = MLTaskExecutor.workerThreadExecutor();

    @KeepForSdk
    public LegacyModelMigrator(@NonNull Context context, @NonNull ModelFileHelper modelFileHelper) {
        this.zzb = context;
        this.modelFileHelper = modelFileHelper;
    }

    @KeepForSdk
    public static void deleteIfEmpty(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        if ((fileArrListFiles == null || fileArrListFiles.length == 0) && !file.delete()) {
            Log.e("MlKitLegacyMigration", "Error deleting model directory ".concat(String.valueOf(file)));
        }
    }

    @KeepForSdk
    public static boolean isValidFirebasePersistenceKey(@NonNull String str) {
        String[] strArrSplit = str.split("\\+", -1);
        if (strArrSplit.length != 2) {
            return false;
        }
        try {
            Base64Utils.decodeUrlSafeNoPadding(strArrSplit[0]);
            Base64Utils.decodeUrlSafeNoPadding(strArrSplit[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public static void migrateFile(@NonNull File file, @NonNull File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                String strValueOf = String.valueOf(file);
                String strValueOf2 = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 28 + strValueOf2.length());
                sb.append("Error moving model file ");
                sb.append(strValueOf);
                sb.append(" to ");
                sb.append(strValueOf2);
                Log.e("MlKitLegacyMigration", sb.toString());
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e("MlKitLegacyMigration", "Error deleting model file ".concat(String.valueOf(file)));
        }
    }

    @NonNull
    @VisibleForTesting
    @KeepForSdk
    public abstract String getLegacyModelDirName();

    @NonNull
    @VisibleForTesting
    @KeepForSdk
    public File getLegacyRootDir() {
        return new File(this.zzb.getNoBackupFilesDir(), getLegacyModelDirName());
    }

    @NonNull
    @KeepForSdk
    public Task<Void> getMigrationTask() {
        return this.zza.getTask();
    }

    @KeepForSdk
    public abstract void migrateAllModelDirs(@NonNull File file);

    @KeepForSdk
    public void start() {
        this.zzc.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.model.zza
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        });
    }

    public final /* synthetic */ void zza() {
        File legacyRootDir = getLegacyRootDir();
        File[] fileArrListFiles = legacyRootDir.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                migrateAllModelDirs(file);
            }
            deleteIfEmpty(legacyRootDir);
        }
        this.zza.setResult(null);
    }
}
