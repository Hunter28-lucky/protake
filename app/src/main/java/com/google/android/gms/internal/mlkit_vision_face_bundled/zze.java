package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zze extends zzi {
    private final Context zza;
    private final zzba zzb;

    public zze(Context context, @Nullable zzba zzbaVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zzbaVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (this.zza.equals(zziVar.zza()) && this.zzb.equals(zziVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String string = this.zza.toString();
        String string2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(string.length() + 46 + string2.length());
        sb.append("FlagsContext{context=");
        sb.append(string);
        sb.append(", hermeticFileOverrides=");
        sb.append(string2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzi
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzi
    @Nullable
    public final zzba zzb() {
        return this.zzb;
    }
}
