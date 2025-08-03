package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzla extends zzln {
    private zzie zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private ModelType zze;
    private zzik zzf;
    private int zzg;
    private byte zzh;

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zza(zzik zzikVar) {
        if (zzikVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zzikVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zzb(zzie zzieVar) {
        if (zzieVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzieVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zzc(int i) {
        this.zzg = i;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zzd(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zze(boolean z) {
        this.zzd = z;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzln zzf(boolean z) {
        this.zzc = z;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzln zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzln
    public final zzlo zzh() {
        zzie zzieVar;
        String str;
        ModelType modelType;
        zzik zzikVar;
        if (this.zzh == 7 && (zzieVar = this.zza) != null && (str = this.zzb) != null && (modelType = this.zze) != null && (zzikVar = this.zzf) != null) {
            return new zzlc(zzieVar, str, this.zzc, this.zzd, modelType, zzikVar, this.zzg, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" errorCode");
        }
        if (this.zzb == null) {
            sb.append(" tfliteSchemaVersion");
        }
        if ((this.zzh & 1) == 0) {
            sb.append(" shouldLogRoughDownloadTime");
        }
        if ((this.zzh & 2) == 0) {
            sb.append(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            sb.append(" modelType");
        }
        if (this.zzf == null) {
            sb.append(" downloadStatus");
        }
        if ((this.zzh & 4) == 0) {
            sb.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
