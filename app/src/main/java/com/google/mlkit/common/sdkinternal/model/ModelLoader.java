package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
@WorkerThread
/* loaded from: classes2.dex */
public class ModelLoader {
    private static final GmsLogger zza = new GmsLogger("ModelLoader", "");

    @Nullable
    @KeepForSdk
    public final LocalModelLoader localModelLoader;

    @NonNull
    @KeepForSdk
    public ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;

    @Nullable
    @KeepForSdk
    @VisibleForTesting
    public final RemoteModelLoader remoteModelLoader;

    @NonNull
    private final ModelLoadingLogger zzb;

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public interface ModelContentHandler {
        @KeepForSdk
        void constructModel(@NonNull MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public interface ModelLoadingLogger {
        @KeepForSdk
        void logErrorCodes(@NonNull List<Integer> list);
    }

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    @KeepForSdk
    public ModelLoader(@Nullable RemoteModelLoader remoteModelLoader, @Nullable LocalModelLoader localModelLoader, @NonNull ModelLoadingLogger modelLoadingLogger) {
        boolean z = true;
        if (remoteModelLoader == null && localModelLoader == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.zzb = modelLoadingLogger;
    }

    private final String zza() {
        LocalModelLoader localModelLoader = this.localModelLoader;
        String string = null;
        if (localModelLoader != null) {
            if (localModelLoader.getLocalModel().getAssetFilePath() != null) {
                string = this.localModelLoader.getLocalModel().getAssetFilePath();
            } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
                string = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            } else if (this.localModelLoader.getLocalModel().getUri() != null) {
                string = ((Uri) Preconditions.checkNotNull(this.localModelLoader.getLocalModel().getUri())).toString();
            }
        }
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        return String.format("Local model path: %s. Remote model name: %s. ", string, remoteModelLoader == null ? "unspecified" : remoteModelLoader.getRemoteModel().getUniqueModelNameForPersist());
    }

    private final synchronized boolean zzb(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        MappedByteBuffer mappedByteBufferLoad;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader == null || (mappedByteBufferLoad = localModelLoader.load()) == null) {
            return false;
        }
        try {
            modelContentHandler.constructModel(mappedByteBufferLoad);
            zza.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e2) {
            list.add(18);
            throw e2;
        }
    }

    private final synchronized boolean zzc(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader != null) {
            try {
                MappedByteBuffer mappedByteBufferLoad = remoteModelLoader.load();
                if (mappedByteBufferLoad != null) {
                    try {
                        modelContentHandler.constructModel(mappedByteBufferLoad);
                        zza.d("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e2) {
                        list.add(19);
                        throw e2;
                    }
                }
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e3) {
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e3;
            }
        }
        return false;
    }

    @KeepForSdk
    public synchronized boolean isRemoteModelLoaded() {
        return this.modelLoadingState == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    @KeepForSdk
    public synchronized void loadWithModelContentHandler(@NonNull ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean zZzc;
        ArrayList arrayList = new ArrayList();
        Exception e2 = null;
        boolean zZzb = false;
        try {
            zZzc = zzc(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e3) {
            exc = e3;
            zZzc = false;
        }
        if (zZzc) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            zZzb = zzb(modelContentHandler, arrayList);
        } catch (Exception e4) {
            e2 = e4;
        }
        if (zZzb) {
            this.zzb.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.zzb.logErrorCodes(arrayList);
        this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            String strValueOf = String.valueOf(zza());
            throw new MlKitException(strValueOf.length() != 0 ? "Remote model load failed with the model options: ".concat(strValueOf) : new String("Remote model load failed with the model options: "), 14, exc);
        }
        if (e2 != null) {
            String strValueOf2 = String.valueOf(zza());
            throw new MlKitException(strValueOf2.length() != 0 ? "Local model load failed with the model options: ".concat(strValueOf2) : new String("Local model load failed with the model options: "), 14, e2);
        }
        String strValueOf3 = String.valueOf(zza());
        throw new MlKitException(strValueOf3.length() != 0 ? "Cannot load any model with the model options: ".concat(strValueOf3) : new String("Cannot load any model with the model options: "), 14);
    }
}
