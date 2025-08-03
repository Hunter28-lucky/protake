package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzrv extends zzon implements zzpt {
    private static final zzrv zzb;
    private int zze;
    private int zzf;
    private zznl zzg = zznl.zzb;
    private String zzh = "";
    private float zzi;

    static {
        zzrv zzrvVar = new zzrv();
        zzb = zzrvVar;
        zzon.zzD(zzrv.class, zzrvVar);
    }

    private zzrv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzrv();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzru(zzrnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
