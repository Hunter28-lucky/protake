package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public abstract class zzlo {
    public static zzln zzh() {
        zzla zzlaVar = new zzla();
        zzlaVar.zzg("NA");
        zzlaVar.zzf(false);
        zzlaVar.zze(false);
        zzlaVar.zzd(ModelType.UNKNOWN);
        zzlaVar.zzb(zzie.NO_ERROR);
        zzlaVar.zza(zzik.UNKNOWN_STATUS);
        zzlaVar.zzc(0);
        return zzlaVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzie zzc();

    public abstract zzik zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
