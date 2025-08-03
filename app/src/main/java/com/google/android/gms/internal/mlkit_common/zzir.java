package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzir {
    private final String zza;
    private final zzip zzc;
    private final String zze;
    private final zzio zzf;
    private final String zzb = null;
    private final String zzd = null;
    private final Long zzg = null;
    private final Boolean zzh = null;
    private final Boolean zzi = null;

    public /* synthetic */ zzir(zzin zzinVar, zziq zziqVar) {
        this.zza = zzinVar.zza;
        this.zzc = zzinVar.zzb;
        this.zze = zzinVar.zzc;
        this.zzf = zzinVar.zzd;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzir)) {
            return false;
        }
        zzir zzirVar = (zzir) obj;
        return Objects.equal(this.zza, zzirVar.zza) && Objects.equal(null, null) && Objects.equal(this.zzc, zzirVar.zzc) && Objects.equal(null, null) && Objects.equal(this.zze, zzirVar.zze) && Objects.equal(this.zzf, zzirVar.zzf) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    @Nullable
    @zzbj(zza = 6)
    public final zzio zza() {
        return this.zzf;
    }

    @Nullable
    @zzbj(zza = 3)
    public final zzip zzb() {
        return this.zzc;
    }

    @Nullable
    @zzbj(zza = 5)
    public final String zzc() {
        return this.zze;
    }

    @Nullable
    @zzbj(zza = 1)
    public final String zzd() {
        return this.zza;
    }
}
