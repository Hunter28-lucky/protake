package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzw;
import com.google.android.gms.internal.mlkit_common.zzx;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public abstract class RemoteModel {

    @Nullable
    private final String zzc;

    @Nullable
    private final BaseModel zzd;
    private final ModelType zze;
    private String zzf;
    private static final Map zzb = new EnumMap(BaseModel.class);

    @NonNull
    @VisibleForTesting
    public static final Map zza = new EnumMap(BaseModel.class);

    @KeepForSdk
    public RemoteModel(@Nullable String str, @Nullable BaseModel baseModel, @NonNull ModelType modelType) {
        Preconditions.checkArgument(TextUtils.isEmpty(str) == (baseModel != null), "One of cloud model name and base model cannot be empty");
        this.zzc = str;
        this.zzd = baseModel;
        this.zze = modelType;
    }

    @KeepForSdk
    public boolean baseModelHashMatches(@NonNull String str) {
        BaseModel baseModel = this.zzd;
        if (baseModel == null) {
            return false;
        }
        return str.equals(zzb.get(baseModel));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return Objects.equal(this.zzc, remoteModel.zzc) && Objects.equal(this.zzd, remoteModel.zzd) && Objects.equal(this.zze, remoteModel.zze);
    }

    @NonNull
    @KeepForSdk
    public String getModelHash() {
        return this.zzf;
    }

    @Nullable
    @KeepForSdk
    public String getModelName() {
        return this.zzc;
    }

    @NonNull
    @KeepForSdk
    public String getModelNameForBackend() {
        String str = this.zzc;
        return str != null ? str : (String) zza.get(this.zzd);
    }

    @NonNull
    @KeepForSdk
    public ModelType getModelType() {
        return this.zze;
    }

    @NonNull
    @KeepForSdk
    public String getUniqueModelNameForPersist() {
        String str = this.zzc;
        if (str != null) {
            return str;
        }
        String strValueOf = String.valueOf((String) zza.get(this.zzd));
        return strValueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(strValueOf) : new String("COM.GOOGLE.BASE_");
    }

    public int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd, this.zze);
    }

    @KeepForSdk
    public boolean isBaseModel() {
        return this.zzd != null;
    }

    @KeepForSdk
    public void setModelHash(@NonNull String str) {
        this.zzf = str;
    }

    @NonNull
    public String toString() {
        zzw zzwVarZzb = zzx.zzb("RemoteModel");
        zzwVarZzb.zza("modelName", this.zzc);
        zzwVarZzb.zza("baseModel", this.zzd);
        zzwVarZzb.zza("modelType", this.zze);
        return zzwVarZzb.toString();
    }
}
