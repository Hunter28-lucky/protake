package com.google.mlkit.vision.common.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.platform.Platform;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
@KeepForSdk
@WorkerThread
/* loaded from: classes2.dex */
public class AutoMLModelUtils {
    private AutoMLModelUtils() {
    }

    @NonNull
    @KeepForSdk
    public static String[] getModelAndLabelFilePaths(@NonNull Context context, @NonNull LocalModel localModel, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        String string;
        String string2 = z ? (String) Preconditions.checkNotNull(localModel.getAssetFilePath()) : (String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath());
        if (localModel.isManifestFile()) {
            ModelUtils.AutoMLManifest manifestFile = ModelUtils.parseManifestFile(string2, z, context);
            if (manifestFile == null) {
                throw new IOException("Failed to parse manifest file.");
            }
            Preconditions.checkState(Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE.equals(manifestFile.getModelType()), "Model type should be: %s.", Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE);
            string2 = new File(new File(string2).getParent(), manifestFile.getModelFile()).toString();
            string = new File(new File(string2).getParent(), manifestFile.getLabelsFile()).toString();
        } else {
            string = "";
        }
        return new String[]{string2, string};
    }

    @NonNull
    @KeepForSdk
    public static List<String> readLabelsFile(@NonNull Context context, @NonNull String str, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        InputStream inputStreamOpen = z ? context.getAssets().open(str) : new FileInputStream(new File(str));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Platform.UTF_8));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                arrayList.add(line);
            }
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
            }
            throw th;
        }
    }
}
