package com.google.android.gms.internal.mlkit_vision_face_bundled;

import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzrd extends zzre {
    public zzrd(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_face_bundled.zzrf.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_face_bundled.zzrf.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_face_bundled.zzrf.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_face_bundled.zzrf.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final void zzc(Object obj, long j, boolean z) {
        if (zzrf.zzb) {
            zzrf.zzi(obj, j, z);
        } else {
            zzrf.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final void zzd(Object obj, long j, byte b) {
        if (zzrf.zzb) {
            zzrf.zzD(obj, j, b);
        } else {
            zzrf.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzre
    public final boolean zzg(Object obj, long j) {
        return zzrf.zzb ? zzrf.zzt(obj, j) : zzrf.zzu(obj, j);
    }
}
