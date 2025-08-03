package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzko {
    private zzjt zza;
    private zzjp zzb;
    private zzjl zzc;
    private Integer zzd;
    private Integer zze;

    public final zzko zzd(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzko zze(zzjl zzjlVar) {
        this.zzc = zzjlVar;
        return this;
    }

    public final zzko zzf(zzjp zzjpVar) {
        this.zzb = zzjpVar;
        return this;
    }

    public final zzko zzg(zzjt zzjtVar) {
        this.zza = zzjtVar;
        return this;
    }

    public final zzko zzh(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzkq zzi() {
        return new zzkq(this, null);
    }
}
