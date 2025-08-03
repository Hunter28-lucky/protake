package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class AutoValue_ModelUtils_AutoMLManifest extends ModelUtils.AutoMLManifest {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public AutoValue_ModelUtils_AutoMLManifest(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null modelFile");
        }
        this.zzb = str2;
        if (str3 == null) {
            throw new NullPointerException("Null labelsFile");
        }
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.AutoMLManifest) {
            ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
            if (this.zza.equals(autoMLManifest.getModelType()) && this.zzb.equals(autoMLManifest.getModelFile()) && this.zzc.equals(autoMLManifest.getLabelsFile())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getLabelsFile() {
        return this.zzc;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getModelFile() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getModelType() {
        return this.zza;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        StringBuilder sb = new StringBuilder(str.length() + 51 + str2.length() + str3.length());
        sb.append("AutoMLManifest{modelType=");
        sb.append(str);
        sb.append(", modelFile=");
        sb.append(str2);
        sb.append(", labelsFile=");
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }
}
