package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zznx {
    private final Object zza;
    private final int zzb;

    public zznx(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznx)) {
            return false;
        }
        zznx zznxVar = (zznx) obj;
        return this.zza == zznxVar.zza && this.zzb == zznxVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
