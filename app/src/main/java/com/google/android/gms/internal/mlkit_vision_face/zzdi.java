package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzdi {
    private zzdl zza;
    private Integer zzb;
    private zzjd zzc;

    public final zzdi zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdi zzb(zzjd zzjdVar) {
        this.zzc = zzjdVar;
        return this;
    }

    public final zzdi zzc(zzdl zzdlVar) {
        this.zza = zzdlVar;
        return this;
    }

    public final zzdn zze() {
        return new zzdn(this, null);
    }
}
