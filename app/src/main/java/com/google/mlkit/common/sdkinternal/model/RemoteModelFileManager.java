package com.google.mlkit.common.sdkinternal.model;

import android.annotation.SuppressLint;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzie;
import com.google.android.gms.internal.mlkit_common.zzik;
import com.google.android.gms.internal.mlkit_common.zzlp;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class RemoteModelFileManager {
    private static final GmsLogger zza = new GmsLogger("RemoteModelFileManager", "");
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;

    @Nullable
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    @SuppressLint({"FirebaseLambdaLast"})
    public RemoteModelFileManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @Nullable ModelValidator modelValidator, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        this.zzb = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.zzd = modelType;
        this.zzc = modelType == ModelType.TRANSLATE ? remoteModel.getModelNameForBackend() : remoteModel.getUniqueModelNameForPersist();
        this.zze = modelValidator;
        this.zzg = SharedPrefManager.getInstance(mlKitContext);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }

    @NonNull
    @KeepForSdk
    public File getModelDirUnsafe(boolean z) {
        return this.zzh.getModelDirUnsafe(this.zzc, this.zzd, z);
    }

    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized File moveModelToPrivateFolder(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull String str, @NonNull RemoteModel remoteModel) throws MlKitException {
        File file;
        MlKitException mlKitException;
        ModelValidator modelValidator;
        file = new File(this.zzh.zza(this.zzc, this.zzd), "to_be_validated_model.tmp");
        ModelValidator.ValidationResult validationResultValidateModel = null;
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = autoCloseInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    autoCloseInputStream.close();
                    boolean zZza = ModelUtils.zza(file, str);
                    if (zZza && (modelValidator = this.zze) != null) {
                        validationResultValidateModel = modelValidator.validateModel(file, remoteModel);
                        if (validationResultValidateModel.getErrorCode().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                            String appVersion = CommonUtils.getAppVersion(this.zzb.getApplicationContext());
                            this.zzg.setIncompatibleModelInfo(remoteModel, str, appVersion);
                            GmsLogger gmsLogger = zza;
                            String strValueOf = String.valueOf(str);
                            gmsLogger.d("RemoteModelFileManager", strValueOf.length() != 0 ? "Model is not compatible. Model hash: ".concat(strValueOf) : new String("Model is not compatible. Model hash: "));
                            String strValueOf2 = String.valueOf(appVersion);
                            gmsLogger.d("RemoteModelFileManager", strValueOf2.length() != 0 ? "The current app version is: ".concat(strValueOf2) : new String("The current app version is: "));
                        }
                    }
                    if (zZza && (validationResultValidateModel == null || validationResultValidateModel.isValid())) {
                    }
                    if (zZza) {
                        mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                    } else {
                        GmsLogger gmsLogger2 = zza;
                        String strValueOf3 = String.valueOf(str);
                        gmsLogger2.d("RemoteModelFileManager", strValueOf3.length() != 0 ? "Hash does not match with expected: ".concat(strValueOf3) : new String("Hash does not match with expected: "));
                        zzlx.zzb("common").zzf(zzlp.zzg(), remoteModel, zzie.MODEL_HASH_MISMATCH, true, this.zzd, zzik.SUCCEEDED);
                        mlKitException = new MlKitException("Hash does not match with expected", 102);
                    }
                    if (file.delete()) {
                        throw mlKitException;
                    }
                    GmsLogger gmsLogger3 = zza;
                    String strValueOf4 = String.valueOf(file.getAbsolutePath());
                    gmsLogger3.d("RemoteModelFileManager", strValueOf4.length() != 0 ? "Failed to delete the temp file: ".concat(strValueOf4) : new String("Failed to delete the temp file: "));
                    throw mlKitException;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    autoCloseInputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
                throw th;
            }
        } catch (IOException e2) {
            zza.e("RemoteModelFileManager", "Failed to copy downloaded model file to private folder: ".concat(e2.toString()));
            return null;
        }
        return this.zzf.moveAllFilesFromPrivateTempToPrivateDestination(file);
    }

    @NonNull
    @WorkerThread
    public final synchronized File zza(@NonNull File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.zzh.getModelDir(this.zzc, this.zzd).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        return file.renameTo(file2) ? file2 : file;
    }

    @Nullable
    @WorkerThread
    public final synchronized String zzb() throws MlKitException {
        return this.zzh.zzb(this.zzc, this.zzd);
    }

    @WorkerThread
    public final synchronized void zzc(@NonNull File file) {
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists()) {
            File[] fileArrListFiles = modelDirUnsafe.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.equals(file)) {
                    this.zzh.deleteRecursively(file);
                    return;
                }
            }
        }
    }

    @WorkerThread
    public final synchronized boolean zzd(@NonNull File file) throws MlKitException {
        File modelDir = this.zzh.getModelDir(this.zzc, this.zzd);
        if (!modelDir.exists()) {
            return false;
        }
        File[] fileArrListFiles = modelDir.listFiles();
        boolean z = true;
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.equals(file) && !this.zzh.deleteRecursively(file2)) {
                z = false;
            }
        }
        return z;
    }
}
