package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzz extends zzon implements zzpt {
    private static final zzz zzb;
    private int zze;
    private float zzf;
    private float zzg;
    private float zzh;

    static {
        zzz zzzVar = new zzz();
        zzb = zzzVar;
        zzon.zzD(zzz.class, zzzVar);
    }

    private zzz() {
    }

    public final float zza() {
        return this.zzf;
    }

    public final float zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzz();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzy(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
