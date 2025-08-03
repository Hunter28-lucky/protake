package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzdj {
    private zzka zza;
    private Boolean zzb;
    private zzjl zzc;
    private Integer zzd;
    private Integer zze;

    public final zzdj zza(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdj zzb(zzjl zzjlVar) {
        this.zzc = zzjlVar;
        return this;
    }

    public final zzdj zzc(zzka zzkaVar) {
        this.zza = zzkaVar;
        return this;
    }

    public final zzdj zzd(Boolean bool) {
        this.zzb = bool;
        return this;
    }

    public final zzdj zze(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdl zzf() {
        return new zzdl(this, null);
    }
}
