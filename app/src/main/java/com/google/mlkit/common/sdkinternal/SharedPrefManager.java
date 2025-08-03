package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class SharedPrefManager {

    @NonNull
    @KeepForSdk
    public static final Component<?> COMPONENT = Component.builder(SharedPrefManager.class).add(Dependency.required(MlKitContext.class)).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.sdkinternal.zzo
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new SharedPrefManager((Context) componentContainer.get(Context.class));
        }
    }).build();

    @NonNull
    @KeepForSdk
    @VisibleForTesting
    public static final String PREF_FILE = "com.google.mlkit.internal";
    private final Context zza;

    public SharedPrefManager(@NonNull Context context) {
        this.zza = context;
    }

    @NonNull
    @KeepForSdk
    public static SharedPrefManager getInstance(@NonNull MlKitContext mlKitContext) {
        return (SharedPrefManager) mlKitContext.get(SharedPrefManager.class);
    }

    private final SharedPreferences zzc() {
        return this.zza.getSharedPreferences(PREF_FILE, 0);
    }

    @KeepForSdk
    public synchronized void clearDownloadingModelInfo(@NonNull RemoteModel remoteModel) {
        zzc().edit().remove(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_type_%s", getDownloadingModelHash(remoteModel))).remove(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist())).apply();
    }

    @KeepForSdk
    public synchronized void clearIncompatibleModelInfo(@NonNull RemoteModel remoteModel) {
        zzc().edit().remove(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove("app_version").apply();
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void clearLatestModelHash(@NonNull RemoteModel remoteModel) {
        zzc().edit().remove(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).commit();
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash(@NonNull RemoteModel remoteModel) {
        return zzc().getString(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingModelId(@NonNull RemoteModel remoteModel) {
        long j = zzc().getLong(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist()), -1L);
        if (j < 0) {
            return null;
        }
        return Long.valueOf(j);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getIncompatibleModelHash(@NonNull RemoteModel remoteModel) {
        return zzc().getString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getLatestModelHash(@NonNull RemoteModel remoteModel) {
        return zzc().getString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @NonNull
    @KeepForSdk
    public synchronized String getMlSdkInstanceId() {
        String string = zzc().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        zzc().edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }

    @KeepForSdk
    public synchronized long getModelDownloadBeginTimeMs(@NonNull RemoteModel remoteModel) {
        return zzc().getLong(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
    }

    @KeepForSdk
    public synchronized long getModelFirstUseTimeMs(@NonNull RemoteModel remoteModel) {
        return zzc().getLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getPreviousAppVersion() {
        return zzc().getString("app_version", null);
    }

    @KeepForSdk
    public synchronized void setDownloadingModelInfo(long j, @NonNull ModelInfo modelInfo) {
        String modelNameForPersist = modelInfo.getModelNameForPersist();
        zzc().edit().putString(String.format("downloading_model_hash_%s", modelNameForPersist), modelInfo.getModelHash()).putLong(String.format("downloading_model_id_%s", modelNameForPersist), j).putLong(String.format("downloading_begin_time_%s", modelNameForPersist), SystemClock.elapsedRealtime()).apply();
    }

    @KeepForSdk
    public synchronized void setIncompatibleModelInfo(@NonNull RemoteModel remoteModel, @NonNull String str, @NonNull String str2) {
        zzc().edit().putString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).putString("app_version", str2).apply();
    }

    @KeepForSdk
    public synchronized void setLatestModelHash(@NonNull RemoteModel remoteModel, @NonNull String str) {
        zzc().edit().putString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).apply();
    }

    @KeepForSdk
    public synchronized void setModelFirstUseTimeMs(@NonNull RemoteModel remoteModel, long j) {
        zzc().edit().putLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), j).apply();
    }

    @Nullable
    public final synchronized String zza(@NonNull String str, long j) {
        return zzc().getString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j)), null);
    }

    public final synchronized void zzb(@NonNull String str, long j, @NonNull String str2) {
        zzc().edit().putString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j)), str2).apply();
    }
}
