package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzjp {
    private final zzjn zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    public /* synthetic */ zzjp(zzjm zzjmVar, zzjo zzjoVar) {
        this.zza = zzjmVar.zza;
        this.zzb = zzjmVar.zzb;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return false;
        }
        zzjp zzjpVar = (zzjp) obj;
        return Objects.equal(this.zza, zzjpVar.zza) && Objects.equal(this.zzb, zzjpVar.zzb) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    @Nullable
    @zzcu(zza = 1)
    public final zzjn zza() {
        return this.zza;
    }

    @Nullable
    @zzcu(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }
}
