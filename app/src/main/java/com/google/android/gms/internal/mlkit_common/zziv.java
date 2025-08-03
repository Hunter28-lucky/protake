package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zziv {
    private final zzir zza;
    private final zzit zzb = null;
    private final zzit zzc = null;
    private final Boolean zzd = null;

    public /* synthetic */ zziv(zzis zzisVar, zziu zziuVar) {
        this.zza = zzisVar.zza;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zziv) && Objects.equal(this.zza, ((zziv) obj).zza) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    @Nullable
    @zzbj(zza = 1)
    public final zzir zza() {
        return this.zza;
    }
}
