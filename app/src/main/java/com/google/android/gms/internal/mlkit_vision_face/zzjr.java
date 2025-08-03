package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzjr {
    private Long zza;
    private zzka zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzjr zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzjr zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzjr zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzjr zzd(zzka zzkaVar) {
        this.zzb = zzkaVar;
        return this;
    }

    public final zzjr zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzjt zzf() {
        return new zzjt(this, null);
    }
}
