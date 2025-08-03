package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class AutoValue_ModelUtils_ModelLoggingInfo extends ModelUtils.ModelLoggingInfo {
    private final long zza;
    private final String zzb;
    private final boolean zzc;

    public AutoValue_ModelUtils_ModelLoggingInfo(long j, String str, boolean z) {
        this.zza = j;
        this.zzb = str;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.zza == modelLoggingInfo.getSize() && this.zzb.equals(modelLoggingInfo.getHash()) && this.zzc == modelLoggingInfo.isManifestModel()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public String getHash() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public long getSize() {
        return this.zza;
    }

    public final int hashCode() {
        long j = this.zza;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ (true != this.zzc ? 1237 : 1231);
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public boolean isManifestModel() {
        return this.zzc;
    }

    public final String toString() {
        long j = this.zza;
        String str = this.zzb;
        boolean z = this.zzc;
        StringBuilder sb = new StringBuilder(str.length() + 71);
        sb.append("ModelLoggingInfo{size=");
        sb.append(j);
        sb.append(", hash=");
        sb.append(str);
        sb.append(", manifestModel=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
