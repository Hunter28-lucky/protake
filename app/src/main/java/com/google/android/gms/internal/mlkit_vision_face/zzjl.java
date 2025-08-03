package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzjl {
    private final zzji zza;
    private final zzjg zzb;
    private final zzjj zzc;
    private final zzjh zzd;
    private final Boolean zze;
    private final Float zzf;

    public /* synthetic */ zzjl(zzjf zzjfVar, zzjk zzjkVar) {
        this.zza = zzjfVar.zza;
        this.zzb = zzjfVar.zzb;
        this.zzc = zzjfVar.zzc;
        this.zzd = zzjfVar.zzd;
        this.zze = zzjfVar.zze;
        this.zzf = zzjfVar.zzf;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjlVar = (zzjl) obj;
        return Objects.equal(this.zza, zzjlVar.zza) && Objects.equal(this.zzb, zzjlVar.zzb) && Objects.equal(this.zzc, zzjlVar.zzc) && Objects.equal(this.zzd, zzjlVar.zzd) && Objects.equal(this.zze, zzjlVar.zze) && Objects.equal(this.zzf, zzjlVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    @Nullable
    @zzcu(zza = 2)
    public final zzjg zza() {
        return this.zzb;
    }

    @Nullable
    @zzcu(zza = 4)
    public final zzjh zzb() {
        return this.zzd;
    }

    @Nullable
    @zzcu(zza = 1)
    public final zzji zzc() {
        return this.zza;
    }

    @Nullable
    @zzcu(zza = 3)
    public final zzjj zzd() {
        return this.zzc;
    }

    @Nullable
    @zzcu(zza = 5)
    public final Boolean zze() {
        return this.zze;
    }

    @Nullable
    @zzcu(zza = 6)
    public final Float zzf() {
        return this.zzf;
    }
}
