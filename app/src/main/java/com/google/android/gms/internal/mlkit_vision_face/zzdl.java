package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzdl {
    private final zzka zza;
    private final Boolean zzb;
    private final zzjp zzc = null;
    private final zzjl zzd;
    private final Integer zze;
    private final Integer zzf;

    public /* synthetic */ zzdl(zzdj zzdjVar, zzdk zzdkVar) {
        this.zza = zzdjVar.zza;
        this.zzb = zzdjVar.zzb;
        this.zzd = zzdjVar.zzc;
        this.zze = zzdjVar.zzd;
        this.zzf = zzdjVar.zze;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdl)) {
            return false;
        }
        zzdl zzdlVar = (zzdl) obj;
        return Objects.equal(this.zza, zzdlVar.zza) && Objects.equal(this.zzb, zzdlVar.zzb) && Objects.equal(null, null) && Objects.equal(this.zzd, zzdlVar.zzd) && Objects.equal(this.zze, zzdlVar.zze) && Objects.equal(this.zzf, zzdlVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, this.zzd, this.zze, this.zzf);
    }

    @Nullable
    @zzcu(zza = 4)
    public final zzjl zza() {
        return this.zzd;
    }

    @Nullable
    @zzcu(zza = 1)
    public final zzka zzb() {
        return this.zza;
    }

    @Nullable
    @zzcu(zza = 2)
    public final Boolean zzc() {
        return this.zzb;
    }

    @Nullable
    @zzcu(zza = 5)
    public final Integer zzd() {
        return this.zze;
    }

    @Nullable
    @zzcu(zza = 6)
    public final Integer zze() {
        return this.zzf;
    }
}
