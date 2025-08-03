package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzij {
    private zziv zza;
    private Long zzb;
    private zzie zzc;
    private Long zzd;
    private zzik zze;
    private Long zzf;

    public final zzij zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzij zzc(zzik zzikVar) {
        this.zze = zzikVar;
        return this;
    }

    public final zzij zzd(zzie zzieVar) {
        this.zzc = zzieVar;
        return this;
    }

    public final zzij zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzij zzf(zziv zzivVar) {
        this.zza = zzivVar;
        return this;
    }

    public final zzij zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzim zzi() {
        return new zzim(this, null);
    }
}
